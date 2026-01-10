// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface StudioMapOfRefTarget : StudioBase {
    val keys: List<MetaIdSpreadsheet>
    val map: Map<MetaIdSpreadsheet, StudioDtoRefTarget>
}
