// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPartition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPartition

open class StudioMapOfPartition : StudioBase()
{
  var keys: Array<MetaIdPartition>? = null
  lateinit var map: Map<MetaIdPartition, StudioDtoPartition>
}