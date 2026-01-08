// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVisibilityAction
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVisibilityAction

interface StudioVisibilityActionMap : StudioBase
{
  val keys: Array<MetaIdVisibilityAction>
  val map: Map<MetaIdVisibilityAction, StudioVisibilityAction>
}