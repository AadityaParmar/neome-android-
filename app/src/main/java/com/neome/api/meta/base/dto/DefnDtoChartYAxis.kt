// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartYAxis
import com.neome.api.meta.base.Types.MetaIdField

class DefnDtoChartYAxis {
    var color: DefnDtoColor? = null
    var colorFieldId: MetaIdField? = null
    var colorVar: DefnDtoColor? = null
    val fieldId: MetaIdField
    var label: string? = null
    val metaId: MetaIdChartYAxis
}
