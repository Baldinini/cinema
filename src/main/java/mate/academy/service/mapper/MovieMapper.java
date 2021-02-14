package mate.academy.service.mapper;

import mate.academy.model.Movie;
import mate.academy.model.dto.MovieRequestDto;
import mate.academy.model.dto.MovieResponseDto;

public interface MovieMapper extends GenericMapper<MovieResponseDto, Movie, MovieRequestDto> {
}
