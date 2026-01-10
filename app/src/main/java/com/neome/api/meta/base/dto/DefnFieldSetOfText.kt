// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldSetOfText : DefnFieldEditable {
    val defaultValue: List<String>?
    val defaultValueFieldId: MetaIdField?
    val optionFieldId: MetaIdField?
    val optionMap: DefnStudioMapOfDtoOption?
    val optionPermissionMap: DefnStudioMapOfOptionPermission?
    val pageSize: Long?
    val pluginApi: DefnDtoPluginApi?
    val pluginErrorFieldId: MetaIdField?
    val showAs: EnumDefnThemePickMultiVariant?
}
