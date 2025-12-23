// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdSendWhatsappMessage : EntVdAutoStep() {
    var mediaField: StudioDtoArgValueParameter? = null
    var message: StudioValueParagraph? = null
    var toUsers: StudioDtoUserFilter? = null
}
