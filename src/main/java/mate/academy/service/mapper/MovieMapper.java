package mate.academy.service.mapper;

import mate.academy.model.Movie;
import mate.academy.model.dto.request.MovieRequestDto;
import mate.academy.model.dto.response.MovieResponseDto;

public interface MovieMapper extends GenericMapperEntityToResponse<Movie, MovieResponseDto>,
        GenericMapperRequestToEntity<MovieRequestDto, Movie> {
}
