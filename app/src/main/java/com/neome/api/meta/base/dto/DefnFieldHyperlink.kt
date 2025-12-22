// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldHyperlink : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultVar: DefnDtoHyperLink? = null
}
