package com.yerayyas.gymroutines.core.data.extensions

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

fun LocalDate.toTimeStamp(): Long {
    return this.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
}

fun ZonedDateTime.toTimeStamp(): Long {
    return this.toInstant().toEpochMilli()
}

fun LocalDate.toZonedDateTime(): ZonedDateTime {
    return this.atStartOfDay(ZoneId.systemDefault())
}

fun LocalTime.toZonedDateTime(): ZonedDateTime {
    return this.atDate(LocalDate.now()).atZone(ZoneId.systemDefault())
}

fun LocalDateTime.toZonedDateTime(): ZonedDateTime {
    return this.atZone(ZoneId.systemDefault())
}

