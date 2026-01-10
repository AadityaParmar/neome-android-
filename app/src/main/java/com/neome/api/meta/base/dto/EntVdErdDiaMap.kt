// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdErdDia

interface EntVdErdDiaMap : StudioBase {
    val keys: List<MetaIdVdErdDia>
    val map: Map<MetaIdVdErdDia, EntVdErdDia>
}
