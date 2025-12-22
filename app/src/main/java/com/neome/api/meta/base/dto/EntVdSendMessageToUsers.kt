// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdSendMessageToUsers : EntVdAutoStep() {
    var message: StudioValueParagraph? = null
    var sender: StudioBuildArgBinder? = null
    var toUsers: StudioDtoUserFilter? = null
}
