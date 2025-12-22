// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class StudioEntAutomationStepSendWhatsappTemplateMessage :
    StudioEntAutomationStepSendMessageBase() {
    var carouselCardMessageVarMap: StudioMapOfVarIdText? = null
    var dataSourceFieldId: MetaIdField? = null
    var mediaFieldId: MetaIdField? = null
    var messageVarMap: StudioMapOfVarIdText? = null
    var templateGroupId: string? = null
}
