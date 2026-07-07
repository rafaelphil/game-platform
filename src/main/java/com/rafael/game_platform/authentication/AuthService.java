package com.rafael.game_platform.authentication;

import com.rafael.game_platform.authentication.records.LoginRequest;
import com.rafael.game_platform.authentication.records.LoginResponse;
import com.rafael.game_platform.exceptions.UsernameAlreadyExistsException;
import com.rafael.game_platform.users.Role;
import com.rafael.game_platform.users.User;
import com.rafael.game_platform.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new LoginResponse(jwtService.generateToken(userDetails));
    }

    public LoginResponse register(LoginRequest loginRequest) {
        if(userRepository.existsByUsername(loginRequest.username())) {
            throw new UsernameAlreadyExistsException(loginRequest.username());
        }

        User user = new User();
        user.setUsername(loginRequest.username());
        user.setPassword(passwordEncoder.encode(loginRequest.password()));
        user.setRole(Role.USER);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));
        userRepository.save(user);
        return new LoginResponse(jwtService.generateToken(userDetails));
    }
}
