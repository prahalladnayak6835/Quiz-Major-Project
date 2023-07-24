package pd.example.demo.major.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pd.example.demo.major.project.model.Proleap;
import pd.example.demo.major.project.service.CourseService;
import pd.example.demo.major.project.service.ProleapService;
import pd.example.demo.major.project.utility.Course;

import java.util.List;

@Controller
public class ProleapController {
    private final ProleapService proleapService;
    private final CourseService courseService;

    @Autowired
    public ProleapController(ProleapService proleapService, CourseService courseService) {
        this.proleapService = proleapService;
        this.courseService = courseService;
    }

    @GetMapping("/proleap-register")
    public String showRegistrationForm(Model model) {
        List<Course> coursesList= courseService.getDropdown();
        System.out.printf(coursesList.toString());
        model.addAttribute("courseList",coursesList);
        model.addAttribute("proleapRegistration", new Proleap());
        return "proleap-register";
    }
    @PostMapping("/proleap-register")
    public String registerCandidate(@ModelAttribute("proleapRegistration")
                                    Proleap proleap, Model model, Course course) {
        proleapService.save(proleap);
        //dropdown
        course.setCourseRegistered(course.getCourseRegistered());
        courseService.save(course);
        model.addAttribute("data1",course.toString());
        //java mail sender
        Proleap registration = new Proleap();
        registration.setEmail(proleap.getEmail());
        registration.setName("Welcome to "+ proleap.getName()+" Mail id");
        registration.setUid(proleap.getUid());
        registration.setPassword(proleap.getPassword());

        proleapService.sendEmail(registration);

        return "index";
    }
}
