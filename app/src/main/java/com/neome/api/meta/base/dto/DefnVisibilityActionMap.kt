// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnVisibilityAction
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVisibilityAction

open class DefnVisibilityActionMap
{
  lateinit var keys: Array<MetaIdVisibilityAction>
  lateinit var map: Map<MetaIdVisibilityAction, DefnVisibilityAction>
}