// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioMapOfValueText

interface EntVdSendWhatsappTemplate : EntVdAutoStep
{
  val buttonIdVarMap: StudioMapOfValueText?
  val carouselCardVarMap: StudioMapOfValueText?
  val templateGroupId: String?
  val templateMediaField: StudioDtoArgValueParameter?
  val templateVarMap: StudioMapOfValueText?
  val toUsers: StudioDtoUserFilter?
}