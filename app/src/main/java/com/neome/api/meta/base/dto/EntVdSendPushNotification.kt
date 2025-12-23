// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdSendPushNotification : EntVdAutoStep() {
    var customMessage: StudioValueParagraph? = null
    var customTitle: StudioValueText? = null
    var customize: Boolean? = null
    var sender: StudioBuildArgBinder? = null
    var toUsers: StudioDtoUserFilter? = null
}
