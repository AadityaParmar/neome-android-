// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeeplink

interface StudioEntDeeplinkMap : StudioBase
{
  val keys: Array<MetaIdDeeplink>
  val map: Map<MetaIdDeeplink, StudioEntDeeplink>
}