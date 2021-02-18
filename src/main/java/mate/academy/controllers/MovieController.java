package mate.academy.controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.model.dto.request.MovieRequestDto;
import mate.academy.model.dto.response.MovieResponseDto;
import mate.academy.service.mapper.MovieMapper;
import mate.academy.service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void addMovie(@RequestBody @Valid MovieRequestDto movieDto) {
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
