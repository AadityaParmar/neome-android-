// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.Types.EnumDefnLocationCapturingMode
import com.neome.api.meta.base.Types.MetaIdRole

interface StudioDtoLocationCapture {
    val excludeDaysSet: List<EnumDefnDay>?
    val frequencyBasedOnDistance: Long?
    val frequencyBasedOnTime: Long?
    val fromTime: AnyTime?
    val roleIdSet: List<MetaIdRole>?
    val toTime: AnyTime?
    val type: EnumDefnLocationCapturingMode?
}
