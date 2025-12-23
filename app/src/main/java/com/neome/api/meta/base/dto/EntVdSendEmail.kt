// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText

open class EntVdSendEmail : EntVdAutoStepWithError()
{
  var attachmentField: StudioDtoArgValueParameter? = null
  var bccUsers: StudioDtoUserFilter? = null
  var ccUsers: StudioDtoUserFilter? = null
  var message: StudioValueParagraph? = null
  var replyToUsers: StudioDtoUserFilter? = null
  var subject: StudioValueText? = null
  var toUsers: StudioDtoUserFilter? = null
}