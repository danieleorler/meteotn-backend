package com.dalendev.meteotn.worker;

import com.dalendev.meteotn.jaxb.generated.WeatherStationList;
import com.dalendev.meteotn.model.Task;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.net.URL;

/**
 * @author daniele.orler
 */
public class StationWorker {

    public static void execute(Task task) throws JAXBException, IOException {

        Unmarshaller unmarshaller = JAXBContext
                .newInstance(WeatherStationList.class)
                .createUnmarshaller();

        StreamSource src = new StreamSource(new URL(task.getUrl()).openStream());
        JAXBElement weatherStationListJAXBElement = unmarshaller.unmarshal(src, WeatherStationList.class);

        WeatherStationList stationList = (WeatherStationList) weatherStationListJAXBElement.getValue();

        stationList.getStationList().forEach( s -> System.out.println(s.getName()));

    }
}
