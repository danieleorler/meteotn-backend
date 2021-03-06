package com.dalendev.meteotn.datafetch.process;

import com.dalendev.meteotn.datafetch.process.TaskQueue;
import com.dalendev.meteotn.model.Task;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author daniele.orler
 */
public class TaskQueueTest {

    @Test
    public void testQueue() {
        TaskQueue.add(new Task(Task.Type.READ_STATION_DATA, "url"));
        TaskQueue.add(new Task(Task.Type.UPDATE_STATION_LIST, "url"));

        assertEquals(TaskQueue.remove().getType(), Task.Type.READ_STATION_DATA);
        assertEquals(TaskQueue.remove().getType(), Task.Type.UPDATE_STATION_LIST);
        assertEquals(0, TaskQueue.size());
    }

}