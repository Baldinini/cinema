package mate.academy.service.mapper;

import mate.academy.model.MovieSession;
import mate.academy.model.dto.request.MovieSessionRequestDto;
import mate.academy.model.dto.response.MovieSessionResponseDto;

public interface MovieSessionMapper extends
        GenericMapperEntityToResponse<MovieSession, MovieSessionResponseDto>,
        GenericMapperRequestToEntity<MovieSessionRequestDto, MovieSession> {
}
