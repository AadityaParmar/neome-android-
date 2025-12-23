// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldPickText : StudioFieldEditable() {
    var defaultOptionFieldId: MetaIdField? = null
    var defaultOptionId: String? = null
    var optionPermissionMap: StudioMapOfOptionPermission? = null
    var pluginApi: StudioDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var pluginInputMappingVarId: MetaIdVar? = null
    var showAs: EnumDefnThemePickVariant? = null
    var source: StudioMapOfOption? = null
    var sourceFieldId: MetaIdField? = null
    var sourceVarId: MetaIdVar? = null
}
