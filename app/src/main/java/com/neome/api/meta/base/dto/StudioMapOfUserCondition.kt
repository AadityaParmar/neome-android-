// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdUserCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoUserConditionStatement

open class StudioMapOfUserCondition : StudioBase()
{
  var andOr: Boolean? = null
  var keys: Array<MetaIdUserCondition>? = null
  var map: Map<MetaIdUserCondition, StudioMapOfUserCondition>? = null
  lateinit var metaId: MetaIdUserCondition
  var statement: StudioDtoUserConditionStatement? = null
}