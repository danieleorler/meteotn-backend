package com.dalendev.meteotn.datafetch.process;

import com.dalendev.meteotn.model.Task;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author daniele.orler
 */
public class TaskQueue {

    private static final Queue<Task> TASK_QUEUE = new ArrayDeque<>();

    public static Queue<Task> getInstance() {
        return TASK_QUEUE;
    }

}
