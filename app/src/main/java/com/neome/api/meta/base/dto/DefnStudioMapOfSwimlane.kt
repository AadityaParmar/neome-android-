// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoSwimlane
import com.neome.api.meta.base.dto.DefnField
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSwimlane

open class DefnStudioMapOfSwimlane : DefnField()
{
  var keys: Array<MetaIdSwimlane>? = null
  lateinit var map: Map<MetaIdSwimlane, DefnDtoSwimlane>
}