// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.google.gson.JsonElement
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdReport

interface DtoEntActionReport : DtoEntAction
{
  val defaultValueMap: Map<MetaIdComp, Any>?
  val inputFormId: MetaIdForm?
  val outputFormContentLayoutId: MetaIdLayoutForm?
  val outputFormId: MetaIdForm
  val outputFormTemplateLayoutId: MetaIdLayoutForm?
  val reportId: MetaIdReport
  val reportKind: EnumDefnKindReport
  val sendMessageToInbox: Boolean?
}