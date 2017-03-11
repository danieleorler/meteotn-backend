package com.dalendev.meteotn.schedule;

import com.dalendev.meteotn.model.Task;
import com.dalendev.meteotn.datafetch.process.TaskQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author daniele.orler
 */
@Component
public class TaskEnqueuer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value(value = "${meteotrentino.base_url}")
    private String baseUrl;

    @Value(value = "${meteotrentino.stations}")
    private String stationsUrl;

    @Value(value = "${meteotrentino.measurements}")
    private String measurementsUrl;

    @Scheduled(cron = "0/10 * * * * *")
    public void equeueStationsTask() {

        TaskQueue.add(new Task(Task.Type.UPDATE_STATION_LIST, baseUrl + stationsUrl));
        log.debug("Enqueued {} task", Task.Type.UPDATE_STATION_LIST.name());
    }

}
