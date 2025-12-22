// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdSendPushNotification : EntVdAutoStep() {
    var customMessage: StudioValueParagraph? = null
    var customTitle: StudioValueText? = null
    var customize: boolean? = null
    var sender: StudioBuildArgBinder? = null
    var toUsers: StudioDtoUserFilter? = null
}
