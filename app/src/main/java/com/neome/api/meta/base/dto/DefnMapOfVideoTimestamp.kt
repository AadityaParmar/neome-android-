// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoVideoTimestamp
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVideoTimestamp

interface DefnMapOfVideoTimestamp
{
  val keys: Array<MetaIdVideoTimestamp>
  val map: Map<MetaIdVideoTimestamp, DefnDtoVideoTimestamp>
}