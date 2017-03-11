package com.dalendev.meteotn.datafetch.process;

import com.dalendev.meteotn.model.Task;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author daniele.orler
 */
public class TaskQueue {

    private static final Queue<Task> TASK_QUEUE = new ArrayDeque<>();

    public static int size() {
        return TASK_QUEUE.size();
    }

    public static boolean isEmpty() {
        return TASK_QUEUE.isEmpty();
    }

    public static boolean contains(Object o) {
        return TASK_QUEUE.contains(o);
    }

    public static Iterator<Task> iterator() {
        return TASK_QUEUE.iterator();
    }

    public static Object[] toArray() {
        return TASK_QUEUE.toArray();
    }

    public static <T> T[] toArray(T[] a) {
        return TASK_QUEUE.toArray(a);
    }

    public static boolean add(Task task) {
        return TASK_QUEUE.add(task);
    }

    public static boolean remove(Object o) {
        return TASK_QUEUE.remove(o);
    }

    public static boolean containsAll(Collection<?> c) {
        return TASK_QUEUE.containsAll(c);
    }

    public static boolean addAll(Collection<? extends Task> c) {
        return TASK_QUEUE.addAll(c);
    }

    public static boolean removeAll(Collection<?> c) {
        return TASK_QUEUE.removeAll(c);
    }

    public static boolean retainAll(Collection<?> c) {
        return TASK_QUEUE.retainAll(c);
    }

    public static void clear() {
        TASK_QUEUE.clear();
    }

    public static boolean offer(Task task) {
        return TASK_QUEUE.offer(task);
    }

    public static Task remove() {
        return TASK_QUEUE.remove();
    }

    public static Task poll() {
        return TASK_QUEUE.poll();
    }

    public static Task element() {
        return TASK_QUEUE.element();
    }

    public static Task peek() {
        return TASK_QUEUE.peek();
    }
}
