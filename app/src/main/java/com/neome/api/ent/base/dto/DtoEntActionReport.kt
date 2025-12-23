// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.google.gson.JsonElement
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdReport

open class DtoEntActionReport : DtoEntAction()
{
  var defaultValueMap: Map<MetaIdComp, Any>? = null
  var inputFormId: MetaIdForm? = null
  var outputFormContentLayoutId: MetaIdLayoutForm? = null
  lateinit var outputFormId: MetaIdForm
  var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
  lateinit var reportId: MetaIdReport
  lateinit var reportKind: EnumDefnKindReport
  var sendMessageToInbox: Boolean? = null
}