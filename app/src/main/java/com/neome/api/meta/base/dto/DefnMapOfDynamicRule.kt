// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule

class DefnMapOfDynamicRule {
    val keys: MetaIdFieldDynamicRule[]
    val map: Record<MetaIdFieldDynamicRule, DefnDtoDynamicRule>
}
