// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioFieldSetOfText : StudioFieldEditable {
    val defaultValue: List<String>?
    val defaultValueFieldId: MetaIdField?
    val optionPermissionMap: StudioMapOfOptionPermission?
    val pluginApi: StudioDtoPluginApi?
    val pluginErrorFieldId: MetaIdField?
    val pluginInputMappingVarId: MetaIdVar?
    val showAs: EnumDefnThemePickMultiVariant?
    val source: StudioMapOfOption?
    val sourceFieldId: MetaIdField?
    val sourceVarId: MetaIdVar?
}
