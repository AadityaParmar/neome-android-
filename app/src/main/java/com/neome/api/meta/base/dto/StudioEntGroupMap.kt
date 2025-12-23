// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup
import java.util.Map

open class StudioEntGroupMap : StudioBase() {
    lateinit var keys: Array<MetaIdGroup>
    lateinit var map: Map<MetaIdGroup, StudioEntGroup>
}
