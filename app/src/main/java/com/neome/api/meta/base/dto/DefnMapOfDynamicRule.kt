// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule
import java.util.Map

open class DefnMapOfDynamicRule {
    lateinit var keys: Array<MetaIdFieldDynamicRule>
    lateinit var map: Map<MetaIdFieldDynamicRule, DefnDtoDynamicRule>
}
