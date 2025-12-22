// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdChartYAxis
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioDtoChartYAxis : StudioBase() {
    var color: StudioDtoColor? = null
    var colorFieldId: MetaIdField? = null
    var colorVarId: MetaIdVar? = null
    var fieldId: MetaIdField? = null
    var label: string? = null
    val metaId: MetaIdChartYAxis
    var name: Symbol? = null
}
