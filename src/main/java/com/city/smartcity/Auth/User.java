package com.city.smartcity.Auth;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String nom ;
    private String prenom ;
    @Id @Column(length = 30)
    private String email ;
    private String password ;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;
    private String role;

}
