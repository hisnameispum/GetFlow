package com.wentura.pomodoro;

import androidx.annotation.NonNull;

public class StatisticsItem implements Comparable<StatisticsItem> {
    private String Date;
    private int CompletedWorks;
    private int Breaks;
    private int CompletedWorksTime;
    private int BreakTime;

    public StatisticsItem(String Date, int CompletedWorks, int Breaks,
                          int CompletedWorksTime, int BreakTime) {
        this.Date = Date;
        this.CompletedWorks = CompletedWorks;
        this.Breaks = Breaks;
        this.BreakTime = BreakTime;
        this.CompletedWorksTime = CompletedWorksTime;
    }

    int getCompletedWorks() {
        return CompletedWorks;
    }

    int getBreaks() {
        return Breaks;
    }

    String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    int getCompletedWorksTime() {
        return CompletedWorksTime;
    }

    int getBreakTime() {
        return BreakTime;
    }

    @Override
    public int compareTo(@NonNull StatisticsItem statisticsItem) {
        return getDate().compareTo(statisticsItem.getDate());
    }
}
