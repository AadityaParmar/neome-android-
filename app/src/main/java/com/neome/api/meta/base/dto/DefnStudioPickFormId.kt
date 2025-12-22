// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

class DefnStudioPickFormId : DefnField() {
    var alias: string? = null
    var allowSystemForms: boolean? = null
    var excludeFormIdSet: MetaIdForm[]? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
}
