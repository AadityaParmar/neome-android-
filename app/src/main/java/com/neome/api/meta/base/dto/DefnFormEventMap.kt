// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnEventActionHolder
import com.neome.api.meta.base.dto.DefnEventConditionHolder
import com.neome.api.meta.base.dto.DefnFormEvent
import com.neome.api.meta.base.Types.MetaIdFormEvent

interface DefnFormEventMap
{
  val actions: DefnEventActionHolder?
  val conditions: DefnEventConditionHolder?
  val keys: List<MetaIdFormEvent>
  val map: Map<MetaIdFormEvent, DefnFormEvent>
}