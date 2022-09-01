package com.prodapt.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private Long id;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
   
    private String password;
}