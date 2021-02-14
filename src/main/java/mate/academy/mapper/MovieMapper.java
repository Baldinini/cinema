package mate.academy.mapper;

import mate.academy.dto.request.MovieRequestDto;
import mate.academy.dto.response.MovieResponseDto;
import mate.academy.model.Movie;

public interface MovieMapper extends GenericMapper<MovieResponseDto, Movie, MovieRequestDto> {
}
