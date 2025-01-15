package it.samu3l.airquality.service;

import it.samu3l.airquality.model.Air;
import it.samu3l.airquality.model.AirDTO;
import it.samu3l.airquality.repository.IAirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AirService implements IAirService {
    @Autowired
    private IAirRepository airRepository;

    @Override
    public Air add(Air air) {
        return airRepository.save(air);
    }

    @Override
    public Air add(AirDTO airDTO) {
        return airRepository.save(new Air(airDTO.getRoom(), airDTO.getCo2(), airDTO.getTemp(), airDTO.getUmid()));
    }

    @Override
    public Iterable<Air> getAll() {
        return airRepository.getAllByOrderByIdDesc();
    }

    @Override
    public Iterable<Air> getAllByRoom(String room) {
        return airRepository.findAllByRoomOrderByIdDesc(room);
    }

    @Override
    public List<Air> getTodayMeasurements() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);
        return airRepository.findByTimestampBetweenOrderByIdDesc(startOfDayTimestamp, endOfDayTimestamp);
    }

    @Override
    public List<Air> getTodayMeasurementsByRoom(String room) {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);
        return airRepository.findByTimestampBetweenAndRoomOrderByIdDesc(startOfDayTimestamp, endOfDayTimestamp, room);
    }

    @Override
    public Air delete(int id) {
        Air air = airRepository.findById(id).orElseThrow();
        airRepository.delete(air);
        return air;
    }
}
