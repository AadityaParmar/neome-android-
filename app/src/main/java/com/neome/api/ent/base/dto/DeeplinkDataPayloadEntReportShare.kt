// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.meta.base.Types.MetaIdLayoutForm

interface DeeplinkDataPayloadEntReportShare : DeeplinkDataPayloadEnt
{
  val defnForm: DefnForm
  val formValue: FormValue
  val outputFormContentLayoutId: MetaIdLayoutForm?
  val outputFormTemplateLayoutId: MetaIdLayoutForm?
  val paperHeight: Long?
  val paperSize: EnumDefnRenderingKind?
  val paperWidth: Long?
  val reportLabel: String?
  val reportName: String
}