package mate.academy.service.mapper.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.model.MovieSession;
import mate.academy.model.dto.request.MovieSessionRequestDto;
import mate.academy.model.dto.response.MovieSessionResponseDto;
import mate.academy.service.mapper.MovieSessionMapper;
import mate.academy.service.service.CinemaHallService;
import mate.academy.service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    private static final String FORMATTER = "dd.MM.yyyy HH:mm";
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapperImpl(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSessionResponseDto convertToDto(MovieSession entity) {
        MovieSessionResponseDto movieSessionDto = new MovieSessionResponseDto();
        movieSessionDto.setId(entity.getId());
        movieSessionDto.setMovieTitle(entity.getMovie().getTitle());
        movieSessionDto.setCinemaHallId(entity.getCinemaHall().getId());
        movieSessionDto.setShowTime(entity.getShowTime()
                .format(DateTimeFormatter.ofPattern(FORMATTER)));
        return movieSessionDto;
    }

    @Override
    public MovieSession convertToEntity(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.getById(requestDto.getMovieId()));
        movieSession
                .setCinemaHall(cinemaHallService.getById(requestDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(requestDto.getShowTime(),
                DateTimeFormatter.ofPattern(FORMATTER)));
        return movieSession;
    }
}
