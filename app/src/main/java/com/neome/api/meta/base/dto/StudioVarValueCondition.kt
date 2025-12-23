// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfCondition

open class StudioVarValueCondition : StudioBase()
{
  var inputFormId: MetaIdForm? = null
  var inputPluginId: MetaIdPlugin? = null
  var node: StudioMapOfCondition? = null
  var sourceFormId: MetaIdForm? = null
  var sourceGridId: MetaIdGrid? = null
  var sourcePluginId: MetaIdPlugin? = null
}