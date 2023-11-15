package com.arch.presentation.util

import android.annotation.SuppressLint
import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.abs

object StringUtils {
    @SuppressLint("SimpleDateFormat")
    fun dateFormat(time: String): String {
        val format = SimpleDateFormat()
        format.applyPattern("yyyy-MM-dd'T'HH:mm:ss")
        var date: Date? = null
        try {
            date = format.parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val now = System.currentTimeMillis()
        date?.let {
            return if (abs(now - date.time) > DateUtils.MINUTE_IN_MILLIS) {
                timeDisplay(date.time, now)
            } else {
                "just now"
            }
        }
        return ""
    }

    private fun timeDisplay(time: Long, now: Long): String {
        if (abs(now - time) > DateUtils.MINUTE_IN_MILLIS && abs(now - time) < DateUtils.WEEK_IN_MILLIS) {
            return getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS).toString()
        }
        if (abs(now - time) > DateUtils.WEEK_IN_MILLIS && abs(now - time) < DateUtils.YEAR_IN_MILLIS) {
            return getRelativeTimeSpanString(time, now, DateUtils.WEEK_IN_MILLIS).toString()
        }
        return if (abs(now - time) > DateUtils.YEAR_IN_MILLIS) {
            getRelativeTimeSpanString(
                time,
                now,
                DateUtils.YEAR_IN_MILLIS
            ).toString()
        } else ""
    }

    private fun getRelativeTimeSpanString(
        time: Long,
        now: Long,
        minResolution: Long
    ): CharSequence {
        val flags =
            DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR or DateUtils.FORMAT_ABBREV_MONTH
        return DateUtils.getRelativeTimeSpanString(time, now, minResolution, flags)
    }
}