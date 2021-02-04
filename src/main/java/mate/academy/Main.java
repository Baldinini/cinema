package mate.academy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import mate.academy.exception.AuthenticationException;
import mate.academy.lib.Injector;
import mate.academy.model.CinemaHall;
import mate.academy.model.Movie;
import mate.academy.model.MovieSession;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.CinemaHallService;
import mate.academy.service.MovieService;
import mate.academy.service.MovieSessionService;
import mate.academy.service.ShoppingCartService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.academy");

    public static void main(String[] args) throws AuthenticationException {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);

        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");

        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);

        CinemaHallService cinemaHallService = (CinemaHallService)
                injector.getInstance(CinemaHallService.class);

        CinemaHall hall = new CinemaHall();
        hall.setCapacity(50);

        cinemaHallService.add(hall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(hall);
        movieSession.setShowTime(LocalDateTime.of(2021, 2, 1, 14, 0));

        MovieSessionService movieSessionService = (MovieSessionService)
                injector.getInstance(MovieSessionService.class);

        System.out.println(movieSessionService.add(movieSession));
        LocalDate localDate = LocalDate.of(2021, 2, 1);
        List<MovieSession> sessions =
                movieSessionService.findAvailableSessions(movie.getId(), localDate);
        sessions.forEach(System.out::println);

        AuthenticationService authenticationService = (AuthenticationService)
                injector.getInstance(AuthenticationService.class);
        User user = authenticationService.register("abracadbra.com", "1234");
        System.out.println(user);

        User userLogin = authenticationService.login("abracadbra.com", "1234");
        System.out.println(userLogin);

        ShoppingCartService shoppingCartService = (ShoppingCartService)
                injector.getInstance(ShoppingCartService.class);

        ShoppingCart shoppingCartByUser = shoppingCartService.getByUser(user);
        System.out.println(shoppingCartByUser);

        shoppingCartService.addSession(movieSession, user);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        System.out.println(shoppingCart);

        shoppingCartService.clear(shoppingCart);
        System.out.println(shoppingCartService.getByUser(user));
    }
}
