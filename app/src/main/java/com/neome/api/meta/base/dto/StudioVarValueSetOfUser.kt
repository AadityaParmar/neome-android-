// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfUserCondition

interface StudioVarValueSetOfUser : StudioBase
{
  val node: StudioMapOfUserCondition?
  val sourceFormId: MetaIdForm?
  val sourcePluginId: MetaIdPlugin?
}