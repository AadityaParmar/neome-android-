// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioValueParagraph

open class EntVdSendWhatsappMessage : EntVdAutoStep()
{
  var mediaField: StudioDtoArgValueParameter? = null
  var message: StudioValueParagraph? = null
  var toUsers: StudioDtoUserFilter? = null
}