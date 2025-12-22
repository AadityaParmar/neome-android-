// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldDateTimeRange : DefnFieldDateTime() {
    var allowSingleDate: boolean? = null
    var fromDefault: DefnBuildDateTime? = null
    var fromDefaultFieldId: MetaIdField? = null
    var fromDefaultVar: DefnBuildDateTime? = null
    var toDefault: DefnBuildDateTime? = null
    var toDefaultFieldId: MetaIdField? = null
    var toDefaultVar: DefnBuildDateTime? = null
}
