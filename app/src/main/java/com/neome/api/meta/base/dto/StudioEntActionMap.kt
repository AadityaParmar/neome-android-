// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAction

interface StudioEntActionMap : StudioBase
{
  val keys: Array<MetaIdAction>
  val map: Map<MetaIdAction, StudioEntAction>
}