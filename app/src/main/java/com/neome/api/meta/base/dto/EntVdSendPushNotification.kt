// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText

open class EntVdSendPushNotification : EntVdAutoStep()
{
  var customMessage: StudioValueParagraph? = null
  var customTitle: StudioValueText? = null
  var customize: Boolean? = null
  var sender: StudioBuildArgBinder? = null
  var toUsers: StudioDtoUserFilter? = null
}