package mate.academy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import mate.academy.config.AppConfig;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.CinemaHall;
import mate.academy.model.Movie;
import mate.academy.model.MovieSession;
import mate.academy.model.Order;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.CinemaHallService;
import mate.academy.service.MovieService;
import mate.academy.service.MovieSessionService;
import mate.academy.service.OrderService;
import mate.academy.service.ShoppingCartService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(String[] args) throws AuthenticationException {
        MovieService movieService = context.getBean(MovieService.class);

        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");

        Movie avengers = new Movie();
        avengers.setTitle("Avengers");
        movieService.add(movie);
        movieService.add(avengers);
        movieService.getAll().forEach(System.out::println);

        CinemaHallService cinemaHallService = context.getBean(CinemaHallService.class);

        CinemaHall hall = new CinemaHall();
        hall.setCapacity(50);

        cinemaHallService.add(hall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(hall);
        movieSession.setShowTime(LocalDateTime.of(2021, 2, 1, 14, 0));

        MovieSession avengersSession = new MovieSession();
        avengersSession.setMovie(avengers);
        avengersSession.setCinemaHall(hall);
        avengersSession.setShowTime(LocalDateTime.of(2020, 3, 2, 21, 0));
        MovieSessionService movieSessionService = context.getBean(MovieSessionService.class);

        System.out.println(movieSessionService.add(movieSession));

        LocalDate localDate = LocalDate.of(2021, 2, 1);
        List<MovieSession> sessions =
                movieSessionService.findAvailableSessions(movie.getId(), localDate);
        sessions.forEach(System.out::println);

        movieSessionService.add(avengersSession);
        List<MovieSession> sessionsForAvengers =
                movieSessionService.findAvailableSessions(avengers.getId(),
                        LocalDate.of(2020, 3, 2));
        sessionsForAvengers.forEach(System.out::println);

        AuthenticationService authenticationService = context.getBean(AuthenticationService.class);
        User user = authenticationService.register("abracadbra.com", "1234");
        System.out.println(user);

        User userLogin = authenticationService.login("abracadbra.com", "1234");
        System.out.println(userLogin);

        ShoppingCartService shoppingCartService = context.getBean(ShoppingCartService.class);

        ShoppingCart shoppingCartByUser = shoppingCartService.getByUser(user);
        System.out.println(shoppingCartByUser);

        shoppingCartService.addSession(movieSession, user);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        System.out.println(shoppingCart);

        shoppingCartService.clear(shoppingCart);
        System.out.println(shoppingCartService.getByUser(user));

        shoppingCartService.addSession(avengersSession, user);
        shoppingCartService.addSession(movieSession,user);
        ShoppingCart scByUser = shoppingCartService.getByUser(user);
        System.out.println(scByUser);

        OrderService orderService = context.getBean(OrderService.class);

        Order order = orderService.completeOrder(scByUser);
        System.out.println(order);

        orderService.getOrdersHistory(user).forEach(System.out::println);
    }
}
