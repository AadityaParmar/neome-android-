// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfJarFile

open class StudioEntPluginJar : StudioBase()
{
  var packageNameVar: String? = null
  var pluginConfigFormId: MetaIdForm? = null
  var uploadJarMap: StudioMapOfJarFile? = null
}