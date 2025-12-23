// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm

open class DefnStudioPickLayoutFormContentId : DefnField()
{
  var excludeLayoutFormContentIdSet: Array<MetaIdLayoutForm>? = null
  var filterKindSet: Array<EnumDefnFormLayoutType>? = null
  lateinit var formId: MetaIdForm
}