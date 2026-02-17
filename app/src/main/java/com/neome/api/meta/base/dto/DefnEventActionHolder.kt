// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnEventAction
import com.neome.api.meta.base.Types.MetaIdFormEventAction

interface DefnEventActionHolder
{
  val map: Map<MetaIdFormEventAction, DefnEventAction>?
}