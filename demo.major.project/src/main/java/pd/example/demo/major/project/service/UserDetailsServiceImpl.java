package pd.example.demo.major.project.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pd.example.demo.major.project.exception.UserNotFound;
import pd.example.demo.major.project.model.User;
import pd.example.demo.major.project.repository.UserRepository;

import java.util.Collections;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;


    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFound(
                    "User is invalid or not exist"
            );
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
