// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition

interface StudioMapOfFieldDynamicCondition : StudioBase {
    val andOr: Boolean?
    val keys: List<MetaIdFieldDynamicCondition>?
    val map: Map<MetaIdFieldDynamicCondition, StudioMapOfFieldDynamicCondition>?
    val metaId: MetaIdFieldDynamicCondition
    val statement: StudioDtoFieldDynamicCondition?
}
