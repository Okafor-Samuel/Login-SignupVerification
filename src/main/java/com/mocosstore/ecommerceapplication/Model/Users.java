package com.mocosstore.ecommerceapplication.Model;

import com.mocosstore.ecommerceapplication.Dto.UsersDto;
import com.mocosstore.ecommerceapplication.Enum.PreferredPaymentMethod;
import com.mocosstore.ecommerceapplication.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.springframework.transaction.annotation.Transactional;

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
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @NaturalId
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String billingAddress;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PreferredPaymentMethod preferredPaymentMethod;

    public Users(UsersDto usersDto){
       this.firstName = usersDto.getFirstName();
       this.lastName = usersDto.getLastName();
       this.email = usersDto.getEmail();
       this.password = usersDto.getPassword();
       this.phoneNumber = usersDto.getPhoneNumber();
       this.role = usersDto.getRole();

    }
}
