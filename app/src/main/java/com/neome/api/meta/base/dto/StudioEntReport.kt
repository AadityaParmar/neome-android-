// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails

open class StudioEntReport : StudioBase()
{
  lateinit var details: StudioDetails
  var inputFormId: MetaIdForm? = null
  lateinit var kind: EnumDefnKindReport
  lateinit var metaId: MetaIdReport
  var outputFormId: MetaIdForm? = null
}