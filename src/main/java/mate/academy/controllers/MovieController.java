package mate.academy.controllers;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.dto.MovieRequestDto;
import mate.academy.model.dto.MovieResponseDto;
import mate.academy.service.MovieService;
import mate.academy.service.mapper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void addMovie(@RequestBody MovieRequestDto movieDto) {
        movieService.add(movieMapper.convertToEntity(movieDto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
