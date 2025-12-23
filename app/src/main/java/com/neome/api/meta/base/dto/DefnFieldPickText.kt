// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldPickText : DefnFieldEditable() {
    var defaultOptionFieldId: MetaIdField? = null
    var defaultOptionId: String? = null
    var optionFieldId: MetaIdField? = null
    var optionMap: DefnStudioMapOfDtoOption? = null
    var optionPermissionMap: DefnStudioMapOfOptionPermission? = null
    var pageSize: Number? = null
    var pluginApi: DefnDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var showAs: EnumDefnThemePickVariant? = null
}
