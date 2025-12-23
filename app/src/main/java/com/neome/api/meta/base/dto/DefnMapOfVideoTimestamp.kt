// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVideoTimestamp
import java.util.Map

open class DefnMapOfVideoTimestamp {
    lateinit var keys: Array<MetaIdVideoTimestamp>
    lateinit var map: Map<MetaIdVideoTimestamp, DefnDtoVideoTimestamp>
}
