// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm

open class DtoNeoScriptLayout : DtoNeoScript()
{
  var formId: MetaIdForm? = null
  var formLayoutId: MetaIdLayoutForm? = null
}