// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioEntDeeplinkWithHeader

interface StudioEntDeeplinkReport : StudioEntDeeplinkWithHeader
{
  val outputFormContentLayoutId: MetaIdLayoutForm?
  val outputFormTemplateLayoutId: MetaIdLayoutForm?
  val reportId: MetaIdReport?
}