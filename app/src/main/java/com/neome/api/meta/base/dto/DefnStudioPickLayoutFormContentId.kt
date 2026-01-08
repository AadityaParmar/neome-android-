// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm

interface DefnStudioPickLayoutFormContentId : DefnField
{
  val excludeLayoutFormContentIdSet: Array<MetaIdLayoutForm>?
  val filterKindSet: Array<EnumDefnFormLayoutType>?
  val formId: MetaIdForm
}