// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindChannelType
import com.neome.api.meta.base.Types.MetaIdPipelineParam

interface EntVdSendHumanLink : EntVdAutoStepWithOutputAndError {
    val embedFormParamId: MetaIdPipelineParam?
    val expiryDatetime: FieldDtoDuration?
    val fromHandle: StudioBuildArgBinder?
    val maxClicks: Long?
    val message: StudioValueParagraph?
    val reminders: Long?
    val sender: StudioBuildArgBinder?
    val targetChannels: List<EnumDefnKindChannelType>?
    val title: StudioValueText?
    val toHandle: StudioBuildArgBinder?
}
