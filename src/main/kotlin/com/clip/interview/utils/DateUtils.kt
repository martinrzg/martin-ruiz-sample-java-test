package com.clip.interview.utils

import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar
import java.util.Date


fun Date.previousValidWeekStart(startDay: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    if (calendar.get(Calendar.DAY_OF_WEEK) < startDay) {
        calendar.add(Calendar.WEEK_OF_YEAR, -1)
    }
    calendar.set(Calendar.DAY_OF_WEEK, startDay)
    var startWeekDate = calendar.time
    if (startWeekDate.toLocalDate().month.ordinal != this.toLocalDate().month.ordinal) {
        calendar.add(Calendar.MONTH, 1)
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        startWeekDate = calendar.time
    }
    return startWeekDate
}

fun Date.nextValidWeekEnd(endDay: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    if (calendar.get(Calendar.DAY_OF_WEEK) > endDay) {
        calendar.add(Calendar.WEEK_OF_YEAR, 1)
    }
    calendar.set(Calendar.DAY_OF_WEEK, endDay)
    var startWeekDate = calendar.time
    if (startWeekDate.toLocalDate().month.ordinal != this.toLocalDate().month.ordinal) {
        calendar.add(Calendar.MONTH, -1)
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        startWeekDate = calendar.time
    }
    return startWeekDate
}

fun Date.toLocalDate(): LocalDate {
    return this.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
}