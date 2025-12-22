// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm

class DefnStudioPickLayoutFormContentId : DefnField() {
    var excludeLayoutFormContentIdSet: MetaIdLayoutForm[]? = null
    var filterKindSet: EnumDefnFormLayoutType[]? = null
    val formId: MetaIdForm
}
