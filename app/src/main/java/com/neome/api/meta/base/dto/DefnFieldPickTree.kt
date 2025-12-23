// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldPickTree : DefnFieldEditable() {
    var autoPickSingleChild: Boolean? = null
    var defaultOptionFieldId: MetaIdField? = null
    var defaultOptionId: String? = null
    var forceLeafSelection: Boolean? = null
    var includeAllChildrenInReport: Boolean? = null
    var pluginApi: DefnDtoPluginApi? = null
    var pluginErrorFieldId: MetaIdField? = null
    var sourceVar: FieldDtoTree? = null
}
