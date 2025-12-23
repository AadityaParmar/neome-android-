// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid

open class DefnStudioPickGridId : DefnFieldEditable()
{
  var excludeGridIdSet: Array<MetaIdGrid>? = null
  lateinit var formId: MetaIdForm
}