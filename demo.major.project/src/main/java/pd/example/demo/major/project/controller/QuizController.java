package pd.example.demo.major.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pd.example.demo.major.project.model.QuestionForm;
import pd.example.demo.major.project.model.Result;
import pd.example.demo.major.project.service.QuizService;

import java.util.List;

@Controller
public class QuizController {
    @Autowired
    Result result;
    @Autowired
    QuizService qService;

    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        return "quiz-index";
    }

    @RequestMapping(value = "/quiz",method = RequestMethod.GET)
    public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
        if(username.equals("")) {
            ra.addFlashAttribute("warning", "You must enter your name");
            return "redirect:/";
        }

        submitted = false;
        result.setUsername(username);

        QuestionForm qForm = qService.getQuestion();
        m.addAttribute("qForm", qForm);

        return "quiz1";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(@ModelAttribute QuestionForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResult(qForm));
            qService.saveScore(result);
            submitted = true;
        }

        return "result";
    }

    @RequestMapping(value = "/score",method = RequestMethod.GET)
    public String score(Model m) {
        List<Result> sList = qService.getTopScore();
        m.addAttribute("sList", sList);

        return "scoreboard";
    }
}
