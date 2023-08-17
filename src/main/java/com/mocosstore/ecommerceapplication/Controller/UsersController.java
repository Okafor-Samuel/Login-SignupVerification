package com.mocosstore.ecommerceapplication.Controller;

import com.mocosstore.ecommerceapplication.Dto.LoginDto;
import com.mocosstore.ecommerceapplication.Dto.UsersDto;
import com.mocosstore.ecommerceapplication.Service.ServiceImpl.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UsersController {
        public final UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody  UsersDto usersDto){
        return (usersService.signup(usersDto));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        return usersService.login(loginDto, session);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        return usersService.logout(session);
    }
}
