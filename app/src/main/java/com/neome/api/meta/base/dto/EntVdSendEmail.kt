// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdSendEmail : EntVdAutoStepWithError() {
    var attachmentField: StudioDtoArgValueParameter? = null
    var bccUsers: StudioDtoUserFilter? = null
    var ccUsers: StudioDtoUserFilter? = null
    var message: StudioValueParagraph? = null
    var replyToUsers: StudioDtoUserFilter? = null
    var subject: StudioValueText? = null
    var toUsers: StudioDtoUserFilter? = null
}
