// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoSwimlane
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdSwimlane

interface DefnStudioMapOfSwimlane : DefnField
{
  val keys: Array<MetaIdSwimlane>?
  val map: Map<MetaIdSwimlane, DefnDtoSwimlane>
}