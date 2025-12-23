// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.dto.EntVdReport
import com.neome.api.meta.base.dto.EntVdReportIOForm
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdVdReportDia
import com.neome.api.meta.base.Symbol

open class EntVdReportDia : EntVdDia()
{
  var ioFormMap: Map<MetaIdForm, EntVdReportIOForm>? = null
  var label: String? = null
  lateinit var metaId: MetaIdVdReportDia
  lateinit var name: Symbol
  var reportMap: Map<MetaIdReport, EntVdReport>? = null
}