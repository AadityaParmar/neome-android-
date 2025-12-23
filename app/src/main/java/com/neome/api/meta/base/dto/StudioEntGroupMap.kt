// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntGroup

open class StudioEntGroupMap : StudioBase()
{
  lateinit var keys: Array<MetaIdGroup>
  lateinit var map: Map<MetaIdGroup, StudioEntGroup>
}