// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoDia
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.dto.StudioBase

open class EntVdAutoDiaMap : StudioBase()
{
  lateinit var keys: Array<MetaIdVdAutoDia>
  lateinit var map: Map<MetaIdVdAutoDia, EntVdAutoDia>
}