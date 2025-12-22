// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindChannelType
import com.neome.api.meta.base.Types.MetaIdPipelineParam

class EntVdSendHumanLink : EntVdAutoStepWithOutputAndError() {
    var embedFormParamId: MetaIdPipelineParam? = null
    var expiryDatetime: FieldDtoDuration? = null
    var fromHandle: StudioBuildArgBinder? = null
    var maxClicks: number? = null
    var message: StudioValueParagraph? = null
    var reminders: number? = null
    var sender: StudioBuildArgBinder? = null
    var targetChannels: EnumDefnKindChannelType[]? = null
    var title: StudioValueText? = null
    var toHandle: StudioBuildArgBinder? = null
}
