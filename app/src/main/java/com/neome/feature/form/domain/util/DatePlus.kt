package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.Types.EnumDefnTime
import com.neome.api.meta.base.dto.DefnBuildDate
import com.neome.api.meta.base.dto.DefnBuildDateTime
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.TemporalAdjusters

/**
 * Date/time utility functions for form arg-value resolution.
 *
 * Port of:
 * - webapp/src/base/plus/NeomeDatePlus.ts (calcDefnBuildDate, calcDefnBuildDateTime, resolveEnumDefnDate)
 * - webapp/src/base/plus/ArgBinderPlus.ts (resolveTimeValue)
 * - webapp/src/base/plus/DatePlus.ts (formatDate, dateToLocalString)
 */
object DatePlus {

    // region --- Time Resolution ---

    /**
     * Resolves an [EnumDefnTime] to a time string.
     * Currently only "now" is defined, returning the current time in "HH:mm:ss" format.
     *
     * Port of: ArgBinderPlus.ts > resolveTimeValue
     */
    fun resolveTimeValue(value: EnumDefnTime?): String? {
        if (value == null) return null
        return when (value) {
            EnumDefnTime.now -> {
                val now = LocalDateTime.now()
                now.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
            }
        }
    }

    // endregion

    // region --- Enum Date Resolution ---

    /**
     * Resolves an [EnumDefnDate] to an ISO date string based on the current date/time.
     * Returns null for context-dependent values like createdOn/updatedOn.
     *
     * Port of: NeomeDatePlus.ts > resolveEnumDefnDate
     */
    fun resolveEnumDefnDate(value: EnumDefnDate): String? {
        val now = ZonedDateTime.now(ZoneOffset.UTC)

        return when (value) {
            EnumDefnDate.now -> now.toInstant().toString()
            EnumDefnDate.yesterday -> now.minusDays(1).toInstant().toString()
            EnumDefnDate.tomorrow -> now.plusDays(1).toInstant().toString()

            EnumDefnDate.startOfWeek -> now
                .with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.SUNDAY))
                .toLocalDate().atStartOfDay(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.endOfWeek -> now
                .with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SATURDAY))
                .toLocalDate().atTime(23, 59, 59, 999_000_000)
                .atZone(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.startOfMonth -> now.toLocalDate()
                .with(TemporalAdjusters.firstDayOfMonth())
                .atStartOfDay(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.endOfMonth -> now.toLocalDate()
                .with(TemporalAdjusters.lastDayOfMonth())
                .atTime(23, 59, 59, 999_000_000)
                .atZone(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.startOfYear -> LocalDate.of(now.year, 1, 1)
                .atStartOfDay(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.endOfYear -> LocalDate.of(now.year, 12, 31)
                .atTime(23, 59, 59, 999_000_000)
                .atZone(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.lastWeek -> now.minusWeeks(1).toInstant().toString()
            EnumDefnDate.nextWeek -> now.plusWeeks(1).toInstant().toString()
            EnumDefnDate.lastMonth -> now.minusMonths(1).toInstant().toString()
            EnumDefnDate.nextMonth -> now.plusMonths(1).toInstant().toString()
            EnumDefnDate.lastQuarter -> now.minusMonths(3).toInstant().toString()
            EnumDefnDate.nextQuarter -> now.plusMonths(3).toInstant().toString()
            EnumDefnDate.lastYear -> now.minusYears(1).toInstant().toString()
            EnumDefnDate.nextYear -> now.plusYears(1).toInstant().toString()

            // Context-dependent — need row data to resolve
            EnumDefnDate.createdOn,
            EnumDefnDate.updatedOn -> null
        }
    }

    // endregion

    // region --- DefnBuild Date/DateTime Resolution ---

    /**
     * Resolves a [DefnBuildDate] to an ISO date string.
     * Tries customValue first, then resolves the enum value using the given timezone.
     *
     * Port of: NeomeDatePlus.ts > calcDefnBuildDate
     */
    fun calcDefnBuildDate(defnBuildDate: DefnBuildDate, timeZone: String): String? {
        val customDate = defnBuildDate.customValue
        val value = defnBuildDate.value

        if (customDate != null) {
            return customDate
        }

        if (value != null) {
            val isoDate = resolveEnumDefnDate(value)
            if (isoDate != null) {
                return convertDateForServer(timeZone, isoDate)
            }
        }

        return null
    }

    /**
     * Resolves a [DefnBuildDateTime] to an ISO date-time string.
     * Handles custom date + optional time component, or enum value + optional time.
     *
     * Port of: NeomeDatePlus.ts > calcDefnBuildDateTime
     */
    fun calcDefnBuildDateTime(defnBuildDateTime: DefnBuildDateTime, timeZone: String): String? {
        val customDate = defnBuildDateTime.customValue
        val value = defnBuildDateTime.value
        val time = defnBuildDateTime.time?.value // AnyTime extends AnyValue, .value is String?

        if (customDate != null) {
            if (time != null) {
                return applyTimeToIsoDate(customDate, time)
            }
            return customDate
        }

        if (value != null) {
            val isoDate = resolveEnumDefnDate(value)
            if (isoDate != null) {
                if (time != null) {
                    return applyTimeToIsoDate(isoDate, time)
                }
                return isoDate
            }
        }

        return null
    }

    // endregion

    // region --- Date Formatting ---

    /**
     * Formats an ISO date string using the given format.
     * Falls back to locale default if format is null.
     *
     * Port of: DatePlus.ts > formatDate
     *
     * @param dateStrISO ISO 8601 date string
     * @param dateTimeFormat format pattern, or "ISO"/"UTC"/"local", or null for locale default
     * @param includeTime whether to include time in the output
     */
    fun formatDate(dateStrISO: String, dateTimeFormat: String?, includeTime: Boolean): String? {
        val instant = parseIsoDate(dateStrISO) ?: return null

        if (includeTime) {
            val zonedDateTime = instant.atZone(ZoneId.systemDefault())
            return when (dateTimeFormat) {
                "ISO" -> instant.toString()
                "UTC" -> instant.atZone(ZoneOffset.UTC)
                    .format(DateTimeFormatter.RFC_1123_DATE_TIME)
                "local" -> zonedDateTime.format(
                    DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.MEDIUM)
                )
                null -> zonedDateTime.format(
                    DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.MEDIUM)
                )
                else -> tryFormatWithPattern(zonedDateTime, dateTimeFormat)
            }
        } else {
            val localDate = instant.atZone(ZoneOffset.UTC).toLocalDate()
            return when (dateTimeFormat) {
                "ISO" -> localDate.toString()
                "UTC" -> localDate.toString()
                "local" -> localDate.format(
                    DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.MEDIUM)
                )
                null -> localDate.format(
                    DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.MEDIUM)
                )
                else -> tryFormatWithPattern(
                    localDate.atStartOfDay(ZoneId.systemDefault()),
                    dateTimeFormat
                )
            }
        }
    }

    /**
     * Converts an ISO date string to a locale-formatted date string.
     *
     * Port of: DatePlus.ts > dateToLocalString
     */
    fun dateToLocalString(value: String): String {
        val instant = parseIsoDate(value)
            ?: return value
        val localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate()
        return localDate.format(
            DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.MEDIUM)
        )
    }

    // endregion

    // region --- Private Helpers ---

    /**
     * Strips the time component from a date and adjusts for timezone difference.
     *
     * Port of: NeomeDatePlus.ts > convertDateForServer
     */
    private fun convertDateForServer(timeZone: String, isoDate: String): String {
        val instant = parseIsoDate(isoDate) ?: return isoDate
        val zoneId = tryParseZoneId(timeZone) ?: return isoDate

        val localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate()
        return localDate.atStartOfDay(zoneId).toInstant().toString()
    }

    /**
     * Parses an ISO date string to an [Instant].
     * Handles both full ISO-8601 and date-only formats.
     */
    private fun parseIsoDate(dateStr: String): Instant? {
        return try {
            Instant.parse(dateStr)
        } catch (_: DateTimeParseException) {
            try {
                LocalDate.parse(dateStr).atStartOfDay(ZoneOffset.UTC).toInstant()
            } catch (_: DateTimeParseException) {
                null
            }
        }
    }

    /**
     * Applies a time string ("HH:mm:ss") to an ISO date string.
     */
    private fun applyTimeToIsoDate(isoDate: String, time: String): String {
        val instant = parseIsoDate(isoDate) ?: return isoDate
        val parts = time.split(":")
        if (parts.size < 3) return isoDate

        val hour = parts[0].toIntOrNull() ?: 0
        val min = parts[1].toIntOrNull() ?: 0
        val sec = parts[2].toIntOrNull() ?: 0

        val zonedDateTime = instant.atZone(ZoneOffset.UTC)
        return zonedDateTime
            .withHour(hour)
            .withMinute(min)
            .withSecond(sec)
            .toInstant()
            .toString()
    }

    /**
     * Tries to parse a timezone string to a [ZoneId].
     */
    private fun tryParseZoneId(timeZone: String): ZoneId? {
        return try {
            ZoneId.of(timeZone)
        } catch (_: Exception) {
            null
        }
    }

    /**
     * Tries to format a [ZonedDateTime] with the given pattern.
     * Falls back to ISO format on parse failure.
     */
    private fun tryFormatWithPattern(dateTime: ZonedDateTime, pattern: String): String {
        return try {
            dateTime.format(DateTimeFormatter.ofPattern(pattern))
        } catch (_: IllegalArgumentException) {
            dateTime.toInstant().toString()
        }
    }

    // endregion
}
