package mate.academy.service.mapper.impl;

import mate.academy.model.User;
import mate.academy.model.dto.request.UserRequestDto;
import mate.academy.model.dto.response.UserResponseDto;
import mate.academy.service.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto convertToDto(User entity) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(entity.getId());
        userDto.setEmail(entity.getEmail());
        return userDto;
    }

    @Override
    public User convertToEntity(UserRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        return user;
    }
}
