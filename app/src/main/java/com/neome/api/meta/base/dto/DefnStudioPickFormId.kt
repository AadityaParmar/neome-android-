// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.MetaIdForm

interface DefnStudioPickFormId : DefnField
{
  val alias: String?
  val allowSystemForms: Boolean?
  val excludeFormIdSet: Array<MetaIdForm>?
  val includeOptionMap: DefnStudioMapOfDtoOption?
}