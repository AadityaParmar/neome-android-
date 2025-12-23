// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar
import java.util.Map

open class StudioVarMap : StudioBase() {
    lateinit var keys: Array<MetaIdVar>
    lateinit var map: Map<MetaIdVar, StudioVar>
}
