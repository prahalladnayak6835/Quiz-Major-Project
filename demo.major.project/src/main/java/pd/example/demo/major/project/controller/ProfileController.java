package pd.example.demo.major.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pd.example.demo.major.project.model.Profile;
import pd.example.demo.major.project.repository.ProfileRepository;
import pd.example.demo.major.project.service.ProfileService;
import pd.example.demo.major.project.service.QualificationService;
import pd.example.demo.major.project.utility.Qualification;

import java.util.List;

@Controller
@RequestMapping
public class ProfileController {
    private final ProfileService profileService;
    //private final ProleapRegisterServiceImpl proleapRegisterServiceImpl;

    private final QualificationService qualificationService;
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    public ProfileController(ProfileService profileService, QualificationService qualificationService) {
        this.profileService = profileService;
        // this.proleapRegisterServiceImpl = proleapRegisterServiceImpl;
        this.qualificationService = qualificationService;
    }

    @GetMapping("/profile-register")
    public String showRegistrationForm(Model model) {
        List<Qualification> qualificationList=qualificationService.getDropDown();
        model.addAttribute("qualificationList", qualificationList);
        model.addAttribute("candidate", new Profile());
        return "profile-register";
    }
    @PostMapping("/profile-register")
    public String registerCandidate(@ModelAttribute("candidate")
                                        Profile profile,
                                    Model model,
                                    Qualification qualification) {
        profileService.register(profile);

        qualification.setHighestQualification(qualification.getHighestQualification());
       // qualificationService.save(qualification);

        model.addAttribute("data",qualification.toString());
        return "redirect:/list-of-candidates";
    }
    @GetMapping("/list-of-candidates")
    public String showRegistrationCandidates(Model model) {
        model.addAttribute("candidate", profileRepository.findAll().stream().toList());
        return "list-of-candidates";
    }
    @PostMapping("/list-of-candidates")
    public String candidate(@ModelAttribute("candidate")
                            Profile profile) {
        profileService.register(profile);
        return "list-of-candidates";
    }

    @RequestMapping("/delete/{profileId}")
    public String deleteCandidate(@PathVariable("profileId") Long profileId) {
        profileService.deleteCandidate(profileId);
        return "redirect:/list-of-candidates";
    }

    @RequestMapping("/update/{profileId}")
    public String updateCandidate(@PathVariable("profileId") String profileId,Model model,Qualification qualification) {
        System.out.println(profileId);
        List<Qualification> qualificationList=qualificationService.getDropDown();
        model.addAttribute("qualificationList", qualificationList);
        model.addAttribute("profile", profileService.getData(profileId));


        model.addAttribute("data",qualification.toString());
        return "update-profile-register";
    }
    @RequestMapping("/update")
    public String update(@ModelAttribute Profile profile,Model model,
                         Qualification qualification) {
        profileService.save(profile);

        qualification.setHighestQualification(qualification.getHighestQualification());
        //qualificationService.save(qualification);

        model.addAttribute("data",qualification.toString());

//        System.out.println(candidate.getId());
        return "redirect:/list-of-candidates";
    }
}
