// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText

interface EntVdSendEmail : EntVdAutoStepWithError
{
  val attachmentField: StudioDtoArgValueParameter?
  val bccUsers: StudioDtoUserFilter?
  val ccUsers: StudioDtoUserFilter?
  val message: StudioValueParagraph?
  val replyToUsers: StudioDtoUserFilter?
  val subject: StudioValueText?
  val toUsers: StudioDtoUserFilter?
}