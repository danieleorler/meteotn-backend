package com.dalendev.meteotn.jaxb.test;

import com.dalendev.meteotn.jaxb.generated.WeatherStationList;
import com.dalendev.meteotn.jaxb.util.UnmarshalHelper;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * @author daniele.orler
 */
public class UnmarshallingTest {

    @Test
    public void testStationUnmarshal() throws JAXBException, IOException {

        File stationsXML = new File(getClass().getClassLoader().getResource("xml/stations_list.xml").getFile());
        WeatherStationList result = UnmarshalHelper.unmarshal(stationsXML, WeatherStationList.class);

        assertEquals(5, result.getStationList().size());
        assertEquals(LocalDate.parse("1921-01-01"), result.getStationList().get(0).getActiveFrom());
        assertEquals(LocalDate.parse("2005-06-22"), result.getStationList().get(0).getActiveUntil());
    }

}
