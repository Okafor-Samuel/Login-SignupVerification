package com.mocosstore.ecommerceapplication.Dto;

import com.mocosstore.ecommerceapplication.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String reEnterPassword;
    private String phoneNumber;
    private Role role;


}
