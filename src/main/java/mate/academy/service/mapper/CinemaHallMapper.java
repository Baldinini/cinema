package mate.academy.service.mapper;

import mate.academy.model.CinemaHall;
import mate.academy.model.dto.request.CinemaHallRequestDto;
import mate.academy.model.dto.response.CinemaHallResponseDto;

public interface CinemaHallMapper extends
        GenericMapperEntityToResponse<CinemaHall, CinemaHallResponseDto>,
        GenericMapperRequestToEntity<CinemaHallRequestDto, CinemaHall> {
}
