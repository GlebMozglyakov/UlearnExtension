package models;

import java.util.UUID;

class Task {
    private final UUID id;
    private final String name;
    private final UUID sectionId;
    private final String sectionName;
    private final TaskType taskType;
    private final int maxScore;;
    private int studentScore;

    public Task(UUID id, String name, UUID sectionId, String sectionName, TaskType taskType, int maxScore, int studentScore) {
        this.id = id;
        this.name = name;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.taskType = taskType;
        this.maxScore = maxScore;
        this.studentScore = studentScore;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int score) {
        if (score >= 0 && score <= maxScore) {
            studentScore = score;
        } else {
            throw new IllegalArgumentException("Балл должен быть больше 0 и меньше максимального");
        }
    }
}