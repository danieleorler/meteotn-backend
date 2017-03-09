package com.dalendev.meteotn.worker;

import com.dalendev.meteotn.model.Task;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author daniele.orler
 */
public class StationWorkerTest {

    @Test
    public void execute() throws Exception {
        Task task = new Task(Task.Type.UPDATE_STATION_LIST, "http://dati.meteotrentino.it/service.asmx/listaStazioni");

        StationWorker.execute(task);
    }

}