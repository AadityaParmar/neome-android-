// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import java.util.Map

open class EntVdAutoDiaMap : StudioBase() {
    lateinit var keys: Array<MetaIdVdAutoDia>
    lateinit var map: Map<MetaIdVdAutoDia, EntVdAutoDia>
}
