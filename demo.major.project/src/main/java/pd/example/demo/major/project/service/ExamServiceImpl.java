package pd.example.demo.major.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pd.example.demo.major.project.model.Exam;
import pd.example.demo.major.project.repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public String register(Exam exam) {
        examRepository.save(exam);
        return "register successfull";
    }

    @Override
    public void sendEmail(Exam exam) {
        examRepository.save(exam);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prahalladnayak2060@gmail.com");
        message.setTo(exam.getEmail());
        message.setSubject(exam.getName());
        message.setText("Hi" +" "+ exam.getName() +
                "\n\n" + "Its time for gear up for your exam rounds." +
                "\n\n" + "YOUR ExamId  :"+ exam.getExamId() +
                "\n\n" + "YOUR ExamSlot :"+ exam.getSlot() +
                "\n\n" + "Your PhoneNo :" + exam.getPhone());


        javaMailSender.send(message);



        System.out.println("Message sent successfully");

    }
}
