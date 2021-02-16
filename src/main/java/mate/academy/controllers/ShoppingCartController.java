package mate.academy.controllers;

import mate.academy.model.MovieSession;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.model.dto.response.ShoppingCartResponseDto;
import mate.academy.service.mapper.ShoppingCartMapper;
import mate.academy.service.service.MovieSessionService;
import mate.academy.service.service.ShoppingCartService;
import mate.academy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper mapper;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper mapper,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.mapper = mapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        User user = userService.getById(userId);
        MovieSession movieSession = movieSessionService.getById(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.getById(userId));
        return mapper.convertToDto(shoppingCart);
    }
}
