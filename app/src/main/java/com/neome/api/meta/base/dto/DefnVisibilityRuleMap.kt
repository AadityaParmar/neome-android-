// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityRule

interface DefnVisibilityRuleMap {
    val keys: List<MetaIdVisibilityRule>
    val map: Map<MetaIdVisibilityRule, DefnVisibilityRule>
}
