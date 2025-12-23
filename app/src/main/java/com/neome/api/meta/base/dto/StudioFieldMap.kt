// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import java.util.Map

open class StudioFieldMap : StudioBase() {
    lateinit var keys: Array<MetaIdField>
    lateinit var map: Map<MetaIdField, StudioField>
}
