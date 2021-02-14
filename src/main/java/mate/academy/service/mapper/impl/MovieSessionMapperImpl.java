package mate.academy.service.mapper.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.model.MovieSession;
import mate.academy.model.dto.MovieSessionRequestDto;
import mate.academy.model.dto.MovieSessionResponseDto;
import mate.academy.service.CinemaHallService;
import mate.academy.service.MovieService;
import mate.academy.service.mapper.MovieSessionMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    public static final String FORMATTER = "dd.MM.yyyy HH:mm";
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapperImpl(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSessionResponseDto convertToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionDto = new MovieSessionResponseDto();
        movieSessionDto.setId(movieSession.getId());
        movieSessionDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionDto.setShowTime(movieSession.getShowTime()
                .format(DateTimeFormatter.ofPattern(FORMATTER)));
        return movieSessionDto;
    }

    @Override
    public MovieSession convertToEntity(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.getById(movieSessionRequestDto.getMovieId()));
        movieSession
                .setCinemaHall(cinemaHallService.getById(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(movieSessionRequestDto.getShowTime(),
                DateTimeFormatter.ofPattern(FORMATTER)));
        return movieSession;
    }
}
