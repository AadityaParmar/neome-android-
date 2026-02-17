// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoVideoTimestamp
import com.neome.api.meta.base.Types.MetaIdVideoTimestamp

interface DefnMapOfVideoTimestamp
{
  val keys: List<MetaIdVideoTimestamp>
  val map: Map<MetaIdVideoTimestamp, DefnDtoVideoTimestamp>
}