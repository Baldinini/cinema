package mate.academy.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mate.academy.model.MovieSession;

public interface MovieSessionDao {
    MovieSession add(MovieSession movieSession);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    void update(MovieSession movieSession);

    void delete(MovieSession movieSession);

    Optional<MovieSession> getById(Long id);
}
