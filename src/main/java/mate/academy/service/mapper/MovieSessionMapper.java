package mate.academy.service.mapper;

import mate.academy.model.MovieSession;
import mate.academy.model.dto.MovieSessionRequestDto;
import mate.academy.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper extends
        GenericMapper<MovieSessionResponseDto, MovieSession, MovieSessionRequestDto> {
}
