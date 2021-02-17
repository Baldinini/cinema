package mate.academy.service.service;

import java.util.List;
import mate.academy.model.CinemaHall;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    CinemaHall getById(Long id);
}
