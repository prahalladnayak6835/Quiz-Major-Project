package pd.example.demo.major.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pd.example.demo.major.project.model.User;
import pd.example.demo.major.project.repository.UserRepository;
import pd.example.demo.major.project.service.UserDetailsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String redirectUrl = null;
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
            redirectUrl="/navigation";

        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
