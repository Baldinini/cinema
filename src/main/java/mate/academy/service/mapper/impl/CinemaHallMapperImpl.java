package mate.academy.service.mapper.impl;

import mate.academy.model.CinemaHall;
import mate.academy.model.dto.CinemaHallRequestDto;
import mate.academy.model.dto.CinemaHallResponseDto;
import mate.academy.service.mapper.CinemaHallMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto convertToDto(CinemaHall entity) {
        CinemaHallResponseDto cinemaHallDto = new CinemaHallResponseDto();
        cinemaHallDto.setId(entity.getId());
        cinemaHallDto.setCapacity(entity.getCapacity());
        cinemaHallDto.setDescription(entity.getDescription());
        return cinemaHallDto;
    }

    @Override
    public CinemaHall convertToEntity(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(requestDto.getDescription());
        return cinemaHall;
    }
}
