package pd.example.demo.major.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;
import pd.example.demo.major.project.controller.ProfileController;
import pd.example.demo.major.project.model.Profile;
import pd.example.demo.major.project.service.ProfileService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService profileService;

    @Test
    public void testShowRegistrationForm() throws Exception {
        mockMvc.perform(get("/ProfileRegister"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("candidate"))
                .andExpect(view().name("ProfileRegister"));
    }



    @Test
    public void testRegisterCandidate() throws Exception {
        Profile candidate = new Profile();
        // Set candidate properties here if needed

        doNothing().when(profileService).register(any(Profile.class));

        mockMvc.perform(post("/ProfileRegister")
                        .flashAttr("candidate", candidate))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));



        }


}