package mate.academy.mapper;

import mate.academy.dto.request.MovieSessionRequestDto;
import mate.academy.dto.response.MovieSessionResponseDto;
import mate.academy.model.MovieSession;

public interface MovieSessionMapper extends GenericMapper<MovieSessionResponseDto, MovieSession, MovieSessionRequestDto> {
}
