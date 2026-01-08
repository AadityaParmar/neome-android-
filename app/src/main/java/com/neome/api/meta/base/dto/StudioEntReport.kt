// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails

interface StudioEntReport : StudioBase
{
  val details: StudioDetails
  val inputFormId: MetaIdForm?
  val kind: EnumDefnKindReport
  val metaId: MetaIdReport
  val outputFormId: MetaIdForm?
}