// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldPickTree : StudioFieldEditable() {
    var defaultOptionFieldId: MetaIdField? = null
    var defaultOptionId: string? = null
    var forceLeafSelection: boolean? = null
    var includeAllChildrenInReport: boolean? = null
    var pluginApi: StudioDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var pluginInputMappingVarId: MetaIdVar? = null
    var sourceVarId: MetaIdVar? = null
}
