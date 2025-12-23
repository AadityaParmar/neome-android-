// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioMapOfValueText

open class EntVdSendWhatsappTemplate : EntVdAutoStep()
{
  var buttonIdVarMap: StudioMapOfValueText? = null
  var carouselCardVarMap: StudioMapOfValueText? = null
  var templateGroupId: String? = null
  var templateMediaField: StudioDtoArgValueParameter? = null
  var templateVarMap: StudioMapOfValueText? = null
  var toUsers: StudioDtoUserFilter? = null
}