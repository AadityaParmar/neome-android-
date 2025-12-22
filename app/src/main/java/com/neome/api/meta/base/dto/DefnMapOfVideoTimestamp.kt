// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVideoTimestamp

class DefnMapOfVideoTimestamp {
    val keys: MetaIdVideoTimestamp[]
    val map: Record<MetaIdVideoTimestamp, DefnDtoVideoTimestamp>
}
