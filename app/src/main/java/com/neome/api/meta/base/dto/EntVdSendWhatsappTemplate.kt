// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdSendWhatsappTemplate : EntVdAutoStep() {
    var buttonIdVarMap: StudioMapOfValueText? = null
    var carouselCardVarMap: StudioMapOfValueText? = null
    var templateGroupId: string? = null
    var templateMediaField: StudioDtoArgValueParameter? = null
    var templateVarMap: StudioMapOfValueText? = null
    var toUsers: StudioDtoUserFilter? = null
}
