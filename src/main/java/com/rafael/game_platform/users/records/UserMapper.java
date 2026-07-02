package com.rafael.game_platform.users.records;

import com.rafael.game_platform.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }
}
