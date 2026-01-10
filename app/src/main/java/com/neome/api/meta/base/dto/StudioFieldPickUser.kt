// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioFieldPickUser : StudioFieldEditable {
    val dataSourceVarId: MetaIdVar?
    val defaultValue: MetaIdRole?
    val defaultValueFieldId: MetaIdField?
    val pluginApi: StudioDtoPluginApi?
    val pluginErrorFieldId: MetaIdField?
    val pluginInputMappingVarId: MetaIdVar?
    val roleIdDataSource: List<MetaIdRole>?
    val showAsDropdown: Boolean?
    val showAsDropdownFieldId: MetaIdField?
    val showAsDropdownVarId: MetaIdVar?
}
