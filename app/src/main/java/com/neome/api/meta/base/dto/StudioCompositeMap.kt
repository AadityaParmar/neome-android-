// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioComposite

interface StudioCompositeMap : StudioBase
{
  val keys: Array<MetaIdComposite>
  val map: Map<MetaIdComposite, StudioComposite>
}