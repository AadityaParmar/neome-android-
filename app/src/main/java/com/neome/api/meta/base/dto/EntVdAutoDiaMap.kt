// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdAutoDia

interface EntVdAutoDiaMap : StudioBase {
    val keys: List<MetaIdVdAutoDia>
    val map: Map<MetaIdVdAutoDia, EntVdAutoDia>
}
