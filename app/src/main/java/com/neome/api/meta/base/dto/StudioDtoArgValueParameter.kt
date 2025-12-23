// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioDtoArgValueField

open class StudioDtoArgValueParameter : StudioDtoArgValueField()
{
  lateinit var paramId: MetaIdPipelineParam
}