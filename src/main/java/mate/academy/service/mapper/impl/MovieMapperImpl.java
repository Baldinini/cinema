package mate.academy.service.mapper.impl;

import mate.academy.model.Movie;
import mate.academy.model.dto.MovieRequestDto;
import mate.academy.model.dto.MovieResponseDto;
import mate.academy.service.mapper.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto convertToDto(Movie entity) {
        MovieResponseDto movieDto = new MovieResponseDto();
        movieDto.setId(entity.getId());
        movieDto.setTitle(entity.getTitle());
        movieDto.setDescription(entity.getDescription());
        return movieDto;
    }

    @Override
    public Movie convertToEntity(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        return movie;
    }
}
