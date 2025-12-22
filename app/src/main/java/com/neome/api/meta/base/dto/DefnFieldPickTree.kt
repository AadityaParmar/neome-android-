// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldPickTree : DefnFieldEditable() {
    var autoPickSingleChild: boolean? = null
    var defaultOptionFieldId: MetaIdField? = null
    var defaultOptionId: string? = null
    var forceLeafSelection: boolean? = null
    var includeAllChildrenInReport: boolean? = null
    var pluginApi: DefnDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var sourceVar: FieldDtoTree? = null
}
