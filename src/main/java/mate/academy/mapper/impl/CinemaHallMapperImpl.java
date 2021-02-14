package mate.academy.mapper.impl;

import mate.academy.dto.request.CinemaHallRequestDto;
import mate.academy.dto.response.CinemaHallResponseDto;
import mate.academy.mapper.CinemaHallMapper;
import mate.academy.mapper.GenericMapper;
import mate.academy.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto convertToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallDto = new CinemaHallResponseDto();
        cinemaHallDto.setId(cinemaHall.getId());
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        return cinemaHallDto;
    }

    @Override
    public CinemaHall convertToEntity(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(cinemaHallRequestDto.getId());
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
