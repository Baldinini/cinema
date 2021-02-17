package mate.academy.service.mapper;

import mate.academy.model.User;
import mate.academy.model.dto.request.UserRequestDto;
import mate.academy.model.dto.response.UserResponseDto;

public interface UserMapper extends
        GenericMapperEntityToResponse<User, UserResponseDto>,
        GenericMapperRequestToEntity<UserRequestDto, User> {
}
