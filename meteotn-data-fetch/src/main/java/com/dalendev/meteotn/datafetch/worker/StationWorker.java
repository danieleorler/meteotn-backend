package com.dalendev.meteotn.datafetch.worker;

import com.dalendev.meteotn.datafetch.dao.StationRepository;
import com.dalendev.meteotn.jaxb.generated.WeatherStation;
import com.dalendev.meteotn.jaxb.generated.WeatherStationList;
import com.dalendev.meteotn.jaxb.util.UnmarshalHelper;
import com.dalendev.meteotn.model.Station;
import com.dalendev.meteotn.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author daniele.orler
 */
@Service
public class StationWorker {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StationRepository stationRepository;

    public Integer execute(Task task) {

        try {
            URL url = new URL(task.getUrl());
            WeatherStationList stationList = UnmarshalHelper.unmarshal(url, WeatherStationList.class);

            List<Station> stations = stationList.getStationList().stream()
                    .filter(s -> s.getActiveUntil() == null)
                    .map(this::map)
                    .collect(Collectors.toList());

            log.debug("{} stations retrieved", stations.size());

            Iterable<Station> savedStations = stationRepository.save(stations);

            log.debug("{} stations stored", savedStations.spliterator().getExactSizeIfKnown());

            return stations.size();
        } catch (JAXBException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Station map(WeatherStation source) {
        return new Station.Builder(source.getCode())
            .withAltitude(source.getAltitude().intValue())
            .withLatitude(source.getLatitude().floatValue())
            .withLongitude(source.getLongitude().floatValue())
            .withName(source.getName())
            .withShortName(source.getShortName())
            .withActiveFrom(source.getActiveFrom())
            .withActiveUntil(source.getActiveUntil())
            .build();
    }
}
