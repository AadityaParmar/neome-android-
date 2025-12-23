// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdErdDia
import java.util.Map

open class EntVdErdDiaMap : StudioBase() {
    lateinit var keys: Array<MetaIdVdErdDia>
    lateinit var map: Map<MetaIdVdErdDia, EntVdErdDia>
}
