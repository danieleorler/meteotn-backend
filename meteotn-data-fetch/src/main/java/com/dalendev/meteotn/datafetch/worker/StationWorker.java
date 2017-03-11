package com.dalendev.meteotn.datafetch.worker;

import com.dalendev.meteotn.jaxb.generated.WeatherStation;
import com.dalendev.meteotn.jaxb.generated.WeatherStationList;
import com.dalendev.meteotn.jaxb.util.UnmarshalHelper;
import com.dalendev.meteotn.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public Integer execute(Task task) {

        try {
            URL url = new URL(task.getUrl());
            WeatherStationList stationList = UnmarshalHelper.unmarshal(url, WeatherStationList.class);

            List<WeatherStation> stations = stationList.getStationList().stream()
                    .filter(s -> s.getTo() == null)
                    .collect(Collectors.toList());

            log.debug("{} stations retrieved", stations.size());

            return stations.size();
        } catch (JAXBException | IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
