package com.city.smartcity.Auth;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(String username);
    UserRecord userToRecord(User user);
    ApplicationUserDetails getPrincipal();

    UserRecord getPrincipalRecord() throws Exception;
}
