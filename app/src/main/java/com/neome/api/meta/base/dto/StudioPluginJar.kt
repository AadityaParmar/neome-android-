// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfJarFile

interface StudioPluginJar : StudioBase
{
  val lastUpdateTime: String
  val packageNameVarId: MetaIdVar?
  val pluginConfigFormId: MetaIdForm?
  val uploadJarMap: StudioMapOfJarFile?
}