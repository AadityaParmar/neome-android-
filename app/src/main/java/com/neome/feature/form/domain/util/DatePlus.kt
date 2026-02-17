package com.neome.feature.form.domain.util

import com.neome.api.meta.base.dto.DefnBuildDate

object DatePlus {

    fun formatDate(dateIsoStr: String, displayDateFormat: String?, isDateTime: Boolean): String {
        return dateIsoStr
//        TODO("Implement formatDate")
    }

    fun dateToLocalString(dateStr: String): String {
        return dateStr
//        TODO("Implement dateToLocalString")
    }

    fun calcDefnBuildDate(defnBuildDate: DefnBuildDate, timeZone: String): String? {
        return defnBuildDate.value?.value ?: defnBuildDate.customValue
//        TODO("Implement calcDefnBuildDate")
    }

    fun calcDefnBuildDateTime(defnBuildDateTime: DefnBuildDate, timeZone: String): String? {
        return defnBuildDateTime.value?.value ?: defnBuildDateTime.customValue
//        TODO("Implement calcDefnBuildDateTime")
    }

    fun resolveTimeValue(value: String?): String? {
        return value
//        TODO("Implement resolveTimeValue")
    }
}
