package com.mocosstore.ecommerceapplication.Model;

import com.mocosstore.ecommerceapplication.Dto.UsersDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @SequenceGenerator(
            name ="users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String billingAddress;

    public Users(UsersDto usersDto){
       this.firstName = usersDto.getFirstName();
       this.lastName = usersDto.getLastName();
       this.email = usersDto.getEmail();
       this.password = usersDto.getPassword();
       this.phoneNumber = usersDto.getPhoneNumber();

    }
}
