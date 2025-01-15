package it.samu3l.airquality.service;

import it.samu3l.airquality.model.Air;
import it.samu3l.airquality.model.AirDTO;

import java.util.List;

public interface IAirService {
    Air add(Air air);

    Air add(AirDTO airDTO);

    Iterable<Air> getAll();

    Iterable<Air> getAllByRoom(String room);

    List<Air> getTodayMeasurements();

    List<Air> getTodayMeasurementsByRoom(String room);

    Air delete(int id);
}
