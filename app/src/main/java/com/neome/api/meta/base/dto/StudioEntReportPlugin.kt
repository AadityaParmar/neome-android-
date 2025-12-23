// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntReportPlugin : StudioEntReport() {
    var inputFormMappingVarId: MetaIdVar? = null
    var outputFormMappingVarId: MetaIdVar? = null
    var pluginApi: StudioDtoPluginApi? = null
}
