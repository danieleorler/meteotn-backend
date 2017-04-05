package com.dalendev.meteotn.datafetch.worker;

import com.dalendev.meteotn.datafetch.dao.StationRepository;
import com.dalendev.meteotn.model.Task;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockserver.integration.ClientAndServer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * @author daniele.orler
 */
@RunWith(MockitoJUnitRunner.class)
public class StationWorkerTest {

    private static ClientAndServer mockServer;

    @Mock
    private StationRepository stationRepository;

    @InjectMocks
    private StationWorker unitUnderTest;

    @BeforeClass
    public static void startMockServer() {
        mockServer = startClientAndServer(1080);
    }

    @AfterClass
    public static void stopMockServer() {
        mockServer.stop();
    }

    @Test
    public void execute() throws Exception {

        File stations = new File(getClass().getClassLoader().getResource("xml/stations_list.xml").getFile());
        String body = new String(Files.readAllBytes(Paths.get(stations.getAbsolutePath())));

        mockServer
                .when(request().withMethod("GET").withPath("/service.asmx/listaStazioni"))
                .respond(response().withBody(body));

        Task task = new Task(Task.Type.UPDATE_STATION_LIST, "http://localhost:1080/service.asmx/listaStazioni");

        Integer result = unitUnderTest.execute(task);

        assertEquals(new Integer(3), result);
    }

}