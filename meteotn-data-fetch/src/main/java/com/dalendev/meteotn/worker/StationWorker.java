package com.dalendev.meteotn.worker;

import com.dalendev.meteotn.jaxb.generated.WeatherStation;
import com.dalendev.meteotn.jaxb.generated.WeatherStationList;
import com.dalendev.meteotn.jaxb.util.UnmarshalHelper;
import com.dalendev.meteotn.model.Task;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author daniele.orler
 */
public class StationWorker {

    public static Integer execute(Task task) throws JAXBException, IOException {

        URL url = new URL(task.getUrl());
        WeatherStationList stationList = UnmarshalHelper.unmarshal(url, WeatherStationList.class);

        List<WeatherStation> stations = stationList.getStationList().stream()
                .filter(s -> s.getTo() == null)
                .collect(Collectors.toList());

        return stations.size();

    }
}
