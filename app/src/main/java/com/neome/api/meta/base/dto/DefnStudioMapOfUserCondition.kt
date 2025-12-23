// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

open class DefnStudioMapOfUserCondition : DefnField()
{
  var formId: MetaIdForm? = null
  var pluginId: MetaIdPlugin? = null
}