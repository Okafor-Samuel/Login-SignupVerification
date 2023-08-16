package com.mocosstore.ecommerceapplication.Service.ServiceImpl;

import com.mocosstore.ecommerceapplication.Dto.LoginDto;
import com.mocosstore.ecommerceapplication.Dto.UsersDto;
import com.mocosstore.ecommerceapplication.Exception.UsersException.PasswordDoesNotMatchException;
import com.mocosstore.ecommerceapplication.Exception.UsersException.UsersAlreadyExistsException;
import com.mocosstore.ecommerceapplication.Exception.UsersException.UsersNotFoundException;
import com.mocosstore.ecommerceapplication.Model.Users;
import com.mocosstore.ecommerceapplication.Repository.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final String USER_NOT_FOUND_MSG ="User with %s not found, please signup";

    public ResponseEntity<String> signup(UsersDto usersDto){
        if (usersAlreadyExists(usersDto.getEmail())){
            throw new UsersAlreadyExistsException("This email address is already in use, please use a different email");
        } else if (!usersDto.getReEnterPassword().equals(usersDto.getPassword())) {
            throw new PasswordDoesNotMatchException("Password does not match, please re-enter a correct password");
        }
        String password = BCrypt.hashpw(usersDto.getPassword(),BCrypt.gensalt());
        usersDto.setPassword(password);
        usersRepository.save(new Users(usersDto));
        return new ResponseEntity<>
                ("Account created successfully, " +
                        "please check your email for a verification code to activate your account ",
                        HttpStatus.CREATED);
    }

    public ResponseEntity<String> login(LoginDto loginDto, HttpSession session){
        Optional<Users> users = usersRepository.findByEmail(loginDto.getEmail());
        if (!users.isPresent()){
            throw new UsersNotFoundException(String.format(USER_NOT_FOUND_MSG,loginDto.getEmail()));
        } else if(users.isPresent()){
            Users targetUser = users.get();
            BCrypt.checkpw(loginDto.getPassword(),targetUser.getPassword());
            session.setAttribute("users",targetUser);
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }else{
            throw new PasswordDoesNotMatchException("email or password incorrect");
        }

    }

//    public ResponseEntity<String> verificationEmail(LoginDto loginDto){
//
//    }
    private boolean usersAlreadyExists(String email) {
        return usersRepository.findByEmail(email).isPresent();
    }

}
