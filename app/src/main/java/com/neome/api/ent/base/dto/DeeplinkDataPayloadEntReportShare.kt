// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.meta.base.Types.MetaIdLayoutForm

open class DeeplinkDataPayloadEntReportShare : DeeplinkDataPayloadEnt()
{
  lateinit var defnForm: DefnForm
  lateinit var formValue: FormValue
  var outputFormContentLayoutId: MetaIdLayoutForm? = null
  var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
  var paperHeight: Number? = null
  var paperSize: EnumDefnRenderingKind? = null
  var paperWidth: Number? = null
  var reportLabel: String? = null
  lateinit var reportName: String
}