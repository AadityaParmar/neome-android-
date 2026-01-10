// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdCondition

interface StudioMapOfCondition : StudioBase {
    val andOr: Boolean?
    val keys: List<MetaIdCondition>?
    val map: Map<MetaIdCondition, StudioMapOfCondition>?
    val metaId: MetaIdCondition
    val statement: StudioDtoConditionStatement?
}
