package com.city.smartcity.Auth;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(String username);
    UserRecord userToRecord(User user);
    ApplicationUserDetails getPrincipal();
    User save(User user) throws Exception;
    UserRecord getPrincipalRecord() throws Exception;
}
