package mate.academy.service.mapper;

import mate.academy.model.CinemaHall;
import mate.academy.model.dto.CinemaHallRequestDto;
import mate.academy.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper extends
        GenericMapper<CinemaHallResponseDto, CinemaHall, CinemaHallRequestDto> {
}
