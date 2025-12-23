// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioComposite

open class StudioCompositeMap : StudioBase()
{
  lateinit var keys: Array<MetaIdComposite>
  lateinit var map: Map<MetaIdComposite, StudioComposite>
}