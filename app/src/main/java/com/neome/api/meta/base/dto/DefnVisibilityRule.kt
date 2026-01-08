// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnVisibilityActionMap
import com.neome.api.meta.base.dto.DefnVisibilityConditionMap
import com.neome.api.meta.base.Types.MetaIdVisibilityRule

interface DefnVisibilityRule
{
  val actionMapIfFalse: DefnVisibilityActionMap
  val actionMapIfTrue: DefnVisibilityActionMap
  val conditionNode: DefnVisibilityConditionMap
  val metaId: MetaIdVisibilityRule
}