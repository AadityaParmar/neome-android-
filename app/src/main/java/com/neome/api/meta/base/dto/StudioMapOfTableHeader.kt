// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdHeader

interface StudioMapOfTableHeader : StudioBase {
    val keys: List<MetaIdHeader>
    val map: Map<MetaIdHeader, StudioDtoTableHeader>
}
