// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar

class StudioPluginJar : StudioBase() {
    val lastUpdateTime: string
    var packageNameVarId: MetaIdVar? = null
    var pluginConfigFormId: MetaIdForm? = null
    var uploadJarMap: StudioMapOfJarFile? = null
}
