package pd.example.demo.major.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pd.example.demo.major.project.model.Exam;
import pd.example.demo.major.project.service.ExamService;
import pd.example.demo.major.project.service.TimeslotService;
import pd.example.demo.major.project.utility.Timeslot;

import java.util.List;

@Controller

public class ExamController {

    private final ExamService examService;
    private final TimeslotService timeslotService;

    @Autowired
    public ExamController(ExamService examService, TimeslotService timeslotService) {
        this.examService = examService;
        this.timeslotService = timeslotService;
    }

    @GetMapping("/exam-register")

    public String showRegistrationForm(Model model) {
        List<Timeslot> timeslotList=timeslotService.getDropDown();
        model.addAttribute("timeslotList", timeslotList);
        model.addAttribute("candidate", new Exam());
        return "exam-register";
    }

    @PostMapping("/exam-register")
    public String registerCandidate(@ModelAttribute("candidate") Exam exam, Model model, Timeslot timeslot) {
        examService.register(exam);
        timeslot.setSlot(timeslot.getSlot());
        timeslotService.save(timeslot);
        Exam registration1 = new Exam();
        registration1.setEmail(exam.getEmail());
        registration1.setName(exam.getName());
        registration1.setExamId(exam.getExamId());
        registration1.setSlot(exam.getSlot());
        registration1.setPhone(exam.getPhone());

        examService.sendEmail(registration1);
        return "index";
    }
}
