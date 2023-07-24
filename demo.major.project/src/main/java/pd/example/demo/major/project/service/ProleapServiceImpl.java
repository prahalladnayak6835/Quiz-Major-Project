package pd.example.demo.major.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pd.example.demo.major.project.model.Proleap;
import pd.example.demo.major.project.repository.ProleapRepository;

@Service
public class ProleapServiceImpl implements ProleapService {
    @Autowired
    private ProleapRepository proleapRepository;

    @Autowired
    private JavaMailSender javaMailSender;



    @Override
    public void save(Proleap proleap) {
        proleapRepository.save(proleap);
    }


    public void sendEmail (Proleap proleap) {

        proleapRepository.save(proleap);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prahalladnayak2060@gmail.com");
        message.setTo(proleap.getEmail());
        message.setSubject(proleap.getName());
        message.setText("YOUR UID IS :"+ proleap.getUid() + "\n\n" + "YOUR PASSWORD IS :"+ proleap.getPassword());


        javaMailSender.send(message);



        System.out.println("Message sent successfully");
    }
}
