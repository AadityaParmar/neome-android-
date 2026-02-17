// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormEventActionBinding
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventActionBinding

interface StudioEventActionBindingMap : StudioBase
{
  val keys: List<MetaIdFormEventActionBinding>
  val map: Map<MetaIdFormEventActionBinding, StudioEventActionBinding>
}