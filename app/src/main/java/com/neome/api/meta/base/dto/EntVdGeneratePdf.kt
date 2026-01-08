// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioValueText

interface EntVdGeneratePdf : EntVdAutoStep
{
  val contentLayoutId: MetaIdLayoutForm?
  val fileName: StudioValueText?
  val outputField: StudioDtoArgValueParameter?
  val templateLayoutId: MetaIdLayoutForm?
}