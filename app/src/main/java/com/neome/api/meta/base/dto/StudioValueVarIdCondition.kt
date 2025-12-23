// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

open class StudioValueVarIdCondition : StudioBase()
{
  lateinit var condVarId: MetaIdVar
  var negation: Boolean? = null
}