// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import java.util.Map

open class StudioFormMap : StudioBase() {
    lateinit var keys: Array<MetaIdForm>
    lateinit var map: Map<MetaIdForm, StudioForm>
}
