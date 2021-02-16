package mate.academy.controllers;

import mate.academy.model.dto.response.UserResponseDto;
import mate.academy.service.mapper.UserMapper;
import mate.academy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @Autowired
    public UserController(UserService userService,UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        return mapper.convertToDto(userService.findByEmail(email).get());
    }
}
