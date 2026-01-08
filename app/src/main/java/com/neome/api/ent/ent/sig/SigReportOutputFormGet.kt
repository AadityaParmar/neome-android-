// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.meta.base.dto.FormValue
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.nucleus.base.sig.Sig

interface SigReportOutputFormGet : Sig
{
  val formId: MetaIdForm
  val formValue: FormValue
  val outputFormContentLayoutId: MetaIdLayoutForm?
  val outputFormTemplateLayoutId: MetaIdLayoutForm?
  val reportLabel: String?
  val reportName: String
}