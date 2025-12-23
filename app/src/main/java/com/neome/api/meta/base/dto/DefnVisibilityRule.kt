// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnVisibilityActionMap
import com.neome.api.meta.base.dto.DefnVisibilityConditionMap
import com.neome.api.meta.base.Types.MetaIdVisibilityRule

open class DefnVisibilityRule
{
  lateinit var actionMapIfFalse: DefnVisibilityActionMap
  lateinit var actionMapIfTrue: DefnVisibilityActionMap
  lateinit var conditionNode: DefnVisibilityConditionMap
  lateinit var metaId: MetaIdVisibilityRule
}