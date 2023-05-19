package com.city.smartcity.Auth;

public interface ApplicationUserDao {
    ApplicationUserDetails getUserByUsername(String username);
}
