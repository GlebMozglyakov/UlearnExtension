package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Section {
    private final UUID id;
    private final String name;
    private final int maxExerciseScore;
    private final int maxPracticeScore;
    private final int maxESeminarScore;
    private final List<Task> tasks;

    public Section(UUID id, String name, int maxExerciseScore, int maxPracticeScore, int maxESeminarScore) {
        this.id = id;
        this.name = name;
        this.maxExerciseScore = maxExerciseScore;
        this.maxPracticeScore = maxPracticeScore;
        this.maxESeminarScore = maxESeminarScore;
        tasks = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxExerciseScore() {
        return maxExerciseScore;
    }

    public int getMaxPracticeScore() {
        return maxPracticeScore;
    }

    public int getMaxESeminarScore() {
        return maxESeminarScore;
    }

    public List<Task> getTasks() {
        List<Task> copyTasks = List.copyOf(tasks);
        return copyTasks;
    }

    public void addTasks(List<Task> addedTasks) {
        if (addedTasks != null && !addedTasks.isEmpty()) {
            tasks.addAll(addedTasks);
        } else {
            throw new IllegalArgumentException("Список не должен быть пустым");
        }
    }

    public void addTask(Task addedTask) {
        if (addedTask != null) {
            tasks.add(addedTask);
        } else {
            throw new IllegalArgumentException("Задача должна быть проинициализирована");
        }
    }
}