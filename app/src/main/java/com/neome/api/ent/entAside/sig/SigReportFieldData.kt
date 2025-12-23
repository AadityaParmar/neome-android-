// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig

open class SigReportFieldData : Sig()
{
  lateinit var reportOutputForm: DefnForm
  lateinit var reportOutputFormValue: FormValue
}