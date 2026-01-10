// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityCondition

interface StudioMapOfVisibilityCondition : StudioBase {
    val andOr: Boolean?
    val keys: List<MetaIdVisibilityCondition>?
    val map: Map<MetaIdVisibilityCondition, StudioMapOfVisibilityCondition>?
    val metaId: MetaIdVisibilityCondition
    val statement: StudioDtoVisibilityCondition?
}
