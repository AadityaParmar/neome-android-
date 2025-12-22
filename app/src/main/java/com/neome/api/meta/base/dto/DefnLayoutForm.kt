// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.MetaIdLayoutForm

class DefnLayoutForm {
    val metaId: MetaIdLayoutForm
    val name: Symbol
    var type: EnumDefnFormLayoutType? = null
}
