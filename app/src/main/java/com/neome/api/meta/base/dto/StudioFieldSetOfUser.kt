// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldSetOfUser : StudioFieldEditable() {
    var dataSourceVarId: MetaIdVar? = null
    var defaultValue: MetaIdRole? = null
    var defaultValueFieldId: MetaIdField? = null
    var pluginApi: StudioDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var pluginInputMappingVarId: MetaIdVar? = null
    var roleIdDataSource: MetaIdRole[]? = null
    var showAsDropdown: boolean? = null
    var showAsDropdownFieldId: MetaIdField? = null
    var showAsDropdownVarId: MetaIdVar? = null
}
