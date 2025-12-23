// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFooter
import java.util.Map

open class DefnStudioMapOfTableFooter {
    lateinit var keys: Array<MetaIdFooter>
    lateinit var map: Map<MetaIdFooter, DefnDtoTableFooter>
}
