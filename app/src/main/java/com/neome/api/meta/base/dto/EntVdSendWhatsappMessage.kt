// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioValueParagraph

interface EntVdSendWhatsappMessage : EntVdAutoStep
{
  val mediaField: StudioDtoArgValueParameter?
  val message: StudioValueParagraph?
  val toUsers: StudioDtoUserFilter?
}