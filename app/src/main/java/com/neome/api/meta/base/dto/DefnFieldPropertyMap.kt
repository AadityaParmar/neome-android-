// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import java.util.Map

open class DefnFieldPropertyMap : DefnFieldEditable() {
    var defaultVar: Map<String, String>? = null
}
