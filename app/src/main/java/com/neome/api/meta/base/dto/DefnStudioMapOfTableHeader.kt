// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdHeader

class DefnStudioMapOfTableHeader {
    val keys: MetaIdHeader[]
    val map: Record<MetaIdHeader, DefnDtoTableHeader>
}
