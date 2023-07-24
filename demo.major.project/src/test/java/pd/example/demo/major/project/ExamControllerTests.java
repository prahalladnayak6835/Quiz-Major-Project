package pd.example.demo.major.project;

import org.junit.jupiter.api.Test;
import pd.example.demo.major.project.controller.ExamController;
import pd.example.demo.major.project.service.ExamService;
import pd.example.demo.major.project.service.TimeslotService;

public class ExamControllerTests {
    public ExamService examService;
    public TimeslotService timeslotService;
@Test
    public void setUp(){
    ExamController examController =new ExamController(examService, timeslotService);
}
}
