// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdForm
import com.neome.api.meta.base.Types.GhostId
import java.util.Map
import com.neome.api.meta.base.dto.StudioBase

open class EntVdFormMap : StudioBase()
{
  lateinit var keys: Array<GhostId>
  lateinit var map: Map<GhostId, EntVdForm>
}