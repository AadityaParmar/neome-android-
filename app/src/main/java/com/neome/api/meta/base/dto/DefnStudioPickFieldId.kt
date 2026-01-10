// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm

interface DefnStudioPickFieldId : DefnFieldEditable {
    val compositeIdSet: List<MetaIdComposite>?
    val excludeFieldIdSet: List<MetaIdField>?
    val filterFieldTypeSet: List<EnumDefnCompType>?
    val formId: MetaIdForm
    val includeFieldIdSet: List<MetaIdField>?
    val includeOptionMap: DefnStudioMapOfDtoOption?
    val showCompositeName: Boolean?
}
