package codv.DFA;

import codv.Tasks.Task;

import java.util.Iterator;
import java.util.LinkedList;

public class Dfa {
    private LinkedList<Task> dfaTaskList;
    public Dfa() {
        dfaTaskList = new LinkedList<Task>();
    }

    public void addTask(Task task) {
        dfaTaskList.add(task);
    }

    public void act(LinkedList<Task> taskList) {
        taskList.addAll(dfaTaskList);
    }
}
