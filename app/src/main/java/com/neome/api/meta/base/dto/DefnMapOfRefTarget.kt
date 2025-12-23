// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import java.util.Map

open class DefnMapOfRefTarget {
    lateinit var keys: Array<MetaIdSpreadsheet>
    lateinit var map: Map<MetaIdSpreadsheet, DefnDtoRefTarget>
}
