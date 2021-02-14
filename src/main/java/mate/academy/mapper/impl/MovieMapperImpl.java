package mate.academy.mapper.impl;

import mate.academy.dto.request.MovieRequestDto;
import mate.academy.dto.response.MovieResponseDto;
import mate.academy.mapper.GenericMapper;
import mate.academy.mapper.MovieMapper;
import mate.academy.model.Movie;
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
