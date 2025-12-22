// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldSetOfText : StudioFieldEditable() {
    var defaultValue: string[]? = null
    var defaultValueFieldId: MetaIdField? = null
    var optionPermissionMap: StudioMapOfOptionPermission? = null
    var pluginApi: StudioDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var pluginInputMappingVarId: MetaIdVar? = null
    var showAs: EnumDefnThemePickMultiVariant? = null
    var source: StudioMapOfOption? = null
    var sourceFieldId: MetaIdField? = null
    var sourceVarId: MetaIdVar? = null
}
