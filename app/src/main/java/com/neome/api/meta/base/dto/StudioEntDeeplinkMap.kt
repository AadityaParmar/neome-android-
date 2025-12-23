// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeeplink

open class StudioEntDeeplinkMap : StudioBase()
{
  lateinit var keys: Array<MetaIdDeeplink>
  lateinit var map: Map<MetaIdDeeplink, StudioEntDeeplink>
}