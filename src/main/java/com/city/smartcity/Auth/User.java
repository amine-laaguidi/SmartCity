package com.city.smartcity.Auth;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String nom ;
    private String prenom ;
    private String nationalite;
    @Id @Column(length = 30)
    private String email ;
    private String password ;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;
    private String role;
    public User() {
        this.enabled = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
        this.accountNonExpired = true;
    }


}
