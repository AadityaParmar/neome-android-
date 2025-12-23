// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdRowSendComment : EntVdAutoStepWithError() {
    var message: StudioValueParagraph? = null
    var rowIdPointer: StudioDtoRowIdPointer? = null
    var sender: StudioBuildArgBinder? = null
}
