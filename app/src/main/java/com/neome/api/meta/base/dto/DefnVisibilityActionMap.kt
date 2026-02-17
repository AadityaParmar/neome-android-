// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnVisibilityAction
import com.neome.api.meta.base.Types.MetaIdVisibilityAction

interface DefnVisibilityActionMap
{
  val keys: List<MetaIdVisibilityAction>
  val map: Map<MetaIdVisibilityAction, DefnVisibilityAction>
}