// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfJarFile

open class StudioPluginJar : StudioBase()
{
  lateinit var lastUpdateTime: String
  var packageNameVarId: MetaIdVar? = null
  var pluginConfigFormId: MetaIdForm? = null
  var uploadJarMap: StudioMapOfJarFile? = null
}