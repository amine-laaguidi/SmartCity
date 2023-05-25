package com.city.smartcity.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(String username) {
        return userRepository.findById(username);
    }

    @Override
    public UserRecord userToRecord(User user) {
        user.setPassword("");
        return new UserRecord(
                user.getNom() +" "+ user.getPrenom(),
                user.getEmail(),
                user.getRole().substring(5));
    }

    @Override
    public ApplicationUserDetails getPrincipal(){
        ApplicationUserDetails user = null;
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof ApplicationUserDetails){
            user =(ApplicationUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }

    @Override
    public UserRecord getPrincipalRecord() throws Exception {
        Optional<User> user = this.findById(this.getPrincipal().getUsername());
        if (user.isPresent())
            return this.userToRecord(user.get());
        else
            throw new Exception("user not found");
    }
}
