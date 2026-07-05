package com.rafael.game_platform.users;

import com.rafael.game_platform.exceptions.UserNotFoundException;
import com.rafael.game_platform.users.records.UserDto;
import com.rafael.game_platform.users.records.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    public UserDto getUserById(Long id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new UserNotFoundException();
        }
        return userMapper.toDto(user);
    }
}
