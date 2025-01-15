package it.samu3l.airquality.repository;

import it.samu3l.airquality.model.Air;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface IAirRepository extends JpaRepository<Air, Integer> {
    Iterable<Air> findAllByRoomOrderByIdDesc(String room);
    Iterable<Air> getAllByOrderByIdDesc();
    List<Air> findByTimestampBetweenOrderByIdDesc(Timestamp timestamp, Timestamp timestamp2);
    List<Air> findByTimestampBetweenAndRoomOrderByIdDesc(Timestamp timestamp, Timestamp timestamp2, String room);
}
