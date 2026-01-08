// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdPrompt
import com.neome.api.meta.base.Types.GhostId
import com.neome.api.meta.base.dto.StudioBase

interface EntVdPromptMap : StudioBase
{
  val keys: Array<GhostId>
  val map: Map<GhostId, EntVdPrompt>
}