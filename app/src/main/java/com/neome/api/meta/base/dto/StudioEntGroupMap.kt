// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup

class StudioEntGroupMap : StudioBase() {
    val keys: MetaIdGroup[]
    val map: Record<MetaIdGroup, StudioEntGroup>
}
