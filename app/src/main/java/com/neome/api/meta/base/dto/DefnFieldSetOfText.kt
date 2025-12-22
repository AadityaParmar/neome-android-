// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldSetOfText : DefnFieldEditable() {
    var defaultValue: string[]? = null
    var defaultValueFieldId: MetaIdField? = null
    var optionFieldId: MetaIdField? = null
    var optionMap: DefnStudioMapOfDtoOption? = null
    var optionPermissionMap: DefnStudioMapOfOptionPermission? = null
    var pageSize: number? = null
    var pluginApi: DefnDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var showAs: EnumDefnThemePickMultiVariant? = null
}
