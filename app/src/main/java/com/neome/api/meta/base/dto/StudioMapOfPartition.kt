// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPartition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPartition

interface StudioMapOfPartition : StudioBase
{
  val keys: List<MetaIdPartition>?
  val map: Map<MetaIdPartition, StudioDtoPartition>
}