// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdForm
import com.neome.api.meta.base.Types.GhostId
import java.util.Map
import com.neome.api.meta.base.dto.StudioBase

interface EntVdFormMap : StudioBase
{
  val keys: Array<GhostId>
  val map: Map<GhostId, EntVdForm>
}