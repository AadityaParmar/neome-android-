// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm

class DefnStudioPickFieldId : DefnFieldEditable() {
    var compositeIdSet: MetaIdComposite[]? = null
    var excludeFieldIdSet: MetaIdField[]? = null
    var filterFieldTypeSet: EnumDefnCompType[]? = null
    val formId: MetaIdForm
    var includeFieldIdSet: MetaIdField[]? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
    var showCompositeName: boolean? = null
}
