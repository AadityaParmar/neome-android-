// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.Types.EnumDefnLocationCapturingMode
import com.neome.api.meta.base.Types.MetaIdRole

open class StudioDtoLocationCapture {
    var excludeDaysSet: Array<EnumDefnDay>? = null
    var frequencyBasedOnDistance: Number? = null
    var frequencyBasedOnTime: Number? = null
    var fromTime: AnyTime? = null
    var roleIdSet: Array<MetaIdRole>? = null
    var toTime: AnyTime? = null
    var type: EnumDefnLocationCapturingMode? = null
}
