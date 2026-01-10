// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup

interface StudioEntGroupMap : StudioBase {
    val keys: List<MetaIdGroup>
    val map: Map<MetaIdGroup, StudioEntGroup>
}
