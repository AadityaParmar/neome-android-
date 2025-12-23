// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityRule
import java.util.Map

open class DefnVisibilityRuleMap {
    lateinit var keys: Array<MetaIdVisibilityRule>
    lateinit var map: Map<MetaIdVisibilityRule, DefnVisibilityRule>
}
