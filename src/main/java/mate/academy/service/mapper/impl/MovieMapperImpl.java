package mate.academy.service.mapper.impl;

import mate.academy.model.Movie;
import mate.academy.model.dto.MovieRequestDto;
import mate.academy.model.dto.MovieResponseDto;
import mate.academy.service.mapper.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto convertToDto(Movie movie) {
        MovieResponseDto movieDto = new MovieResponseDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        return movieDto;
    }

    @Override
    public Movie convertToEntity(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setId(movieRequestDto.getId());
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
