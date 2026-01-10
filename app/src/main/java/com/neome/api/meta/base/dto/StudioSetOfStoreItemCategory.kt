// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStoreLabel

interface StudioSetOfStoreItemCategory : StudioBase {
    val valueSet: List<EnumStoreLabel>
}
