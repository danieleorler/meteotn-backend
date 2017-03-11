package com.dalendev.meteotn.schedule;

import com.dalendev.meteotn.datafetch.process.TaskQueue;
import com.dalendev.meteotn.datafetch.worker.StationWorker;
import com.dalendev.meteotn.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author daniele.orler
 */
@Component
public class TaskExecutor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StationWorker stationWorker;

    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void executeTask() {

        if(!TaskQueue.isEmpty()) {
            Task task = TaskQueue.remove();

            log.debug("Dequeued a {} task", task.getType().name());

            if(task.getType() == Task.Type.UPDATE_STATION_LIST) {
                stationWorker.execute(task);
            }

        } else {
            log.debug("Task Queue is empty, nothing to do!");
        }
    }

}
