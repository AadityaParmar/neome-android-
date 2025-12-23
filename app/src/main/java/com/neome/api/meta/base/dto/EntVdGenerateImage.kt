// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioValueText

open class EntVdGenerateImage : EntVdAutoStep()
{
  var contentLayoutId: MetaIdLayoutForm? = null
  var fileName: StudioValueText? = null
  var outputField: StudioDtoArgValueParameter? = null
  var templateLayoutId: MetaIdLayoutForm? = null
}