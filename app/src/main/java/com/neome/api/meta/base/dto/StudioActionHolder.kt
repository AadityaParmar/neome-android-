// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormEventAction
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventAction

interface StudioActionHolder : StudioBase
{
  val map: Map<MetaIdFormEventAction, StudioEventAction>?
}