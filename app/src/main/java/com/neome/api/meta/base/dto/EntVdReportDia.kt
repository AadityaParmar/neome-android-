// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.dto.EntVdReport
import com.neome.api.meta.base.dto.EntVdReportIOForm
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdVdReportDia
import com.neome.api.meta.base.Symbol

interface EntVdReportDia : EntVdDia
{
  val ioFormMap: Map<MetaIdForm, EntVdReportIOForm>?
  val label: String?
  val metaId: MetaIdVdReportDia
  val name: Symbol
  val reportMap: Map<MetaIdReport, EntVdReport>?
}