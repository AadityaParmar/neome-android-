// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdErdDia

class EntVdErdDiaMap : StudioBase() {
    val keys: MetaIdVdErdDia[]
    val map: Record<MetaIdVdErdDia, EntVdErdDia>
}
