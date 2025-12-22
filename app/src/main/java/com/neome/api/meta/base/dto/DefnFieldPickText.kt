// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldPickText : DefnFieldEditable() {
    var defaultOptionFieldId: MetaIdField? = null
    var defaultOptionId: string? = null
    var optionFieldId: MetaIdField? = null
    var optionMap: DefnStudioMapOfDtoOption? = null
    var optionPermissionMap: DefnStudioMapOfOptionPermission? = null
    var pageSize: number? = null
    var pluginApi: DefnDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var showAs: EnumDefnThemePickVariant? = null
}
