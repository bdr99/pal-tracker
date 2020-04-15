package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> list;
    private long nextId = 1L;

    public InMemoryTimeEntryRepository() {
        this.list = new ArrayList<TimeEntry>();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry entry = new TimeEntry(nextId, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        nextId += 1L;
        list.add(entry);
        return entry;
    }

    public TimeEntry find(long timeEntryId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == timeEntryId) return list.get(i);
        }
        return null;
    }

    public List<TimeEntry> list() {
        return list;
    }

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == timeEntryId) {
                TimeEntry newEntry = new TimeEntry(timeEntryId, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
                list.set(i, newEntry);
                return newEntry;
            }
        }
        return null;
    }

    public void delete(long timeEntryId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == timeEntryId) list.remove(i);
        }
    }
}
