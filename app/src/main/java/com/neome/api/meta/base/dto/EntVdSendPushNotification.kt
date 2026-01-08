// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText

interface EntVdSendPushNotification : EntVdAutoStep
{
  val customMessage: StudioValueParagraph?
  val customTitle: StudioValueText?
  val customize: Boolean?
  val sender: StudioBuildArgBinder?
  val toUsers: StudioDtoUserFilter?
}