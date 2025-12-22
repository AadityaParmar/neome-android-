// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.Types.EnumDefnLocationCapturingMode
import com.neome.api.meta.base.Types.MetaIdRole

class StudioDtoLocationCapture {
    var excludeDaysSet: EnumDefnDay[]? = null
    var frequencyBasedOnDistance: number? = null
    var frequencyBasedOnTime: number? = null
    var fromTime: AnyTime? = null
    var roleIdSet: MetaIdRole[]? = null
    var toTime: AnyTime? = null
    var type: EnumDefnLocationCapturingMode? = null
}
