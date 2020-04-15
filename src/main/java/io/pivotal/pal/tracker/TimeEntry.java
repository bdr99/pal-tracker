package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Random;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {
        //this(0L, new Random().nextLong(), new Random().nextLong(), LocalDate.parse("2000-01-01"), 8);
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this(0L, projectId, userId, date, hours);
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this.id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeEntry entry = (TimeEntry) o;

        if (this.id != entry.id) return false;
        if (this.projectId != entry.projectId) return false;
        if (this.userId != entry.userId) return false;
        if (!(this.date.equals(entry.date))) return false;
        if (this.hours != entry.hours) return false;
        return true;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", hours=" + hours +
                '}';
    }
}
