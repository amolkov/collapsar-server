package ru.molkov.setting

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    val DF_SIMPLE_FORMAT: SimpleDateFormat = SimpleDateFormat(Constants.NASA_DATE_FORMAT, Locale.US)
}

fun Date.asString(): String = DateHelper.DF_SIMPLE_FORMAT.format(this)