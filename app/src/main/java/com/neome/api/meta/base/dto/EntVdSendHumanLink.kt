// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.Types.EnumDefnKindChannelType
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText

open class EntVdSendHumanLink : EntVdAutoStepWithOutputAndError()
{
  var embedFormParamId: MetaIdPipelineParam? = null
  var expiryDatetime: FieldDtoDuration? = null
  var fromHandle: StudioBuildArgBinder? = null
  var maxClicks: Number? = null
  var message: StudioValueParagraph? = null
  var reminders: Number? = null
  var sender: StudioBuildArgBinder? = null
  var targetChannels: Array<EnumDefnKindChannelType>? = null
  var title: StudioValueText? = null
  var toHandle: StudioBuildArgBinder? = null
}