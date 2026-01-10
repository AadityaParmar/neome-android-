// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

interface DefnStudioPickFormId : DefnField {
    val alias: String?
    val allowSystemForms: Boolean?
    val excludeFormIdSet: List<MetaIdForm>?
    val includeOptionMap: DefnStudioMapOfDtoOption?
}
