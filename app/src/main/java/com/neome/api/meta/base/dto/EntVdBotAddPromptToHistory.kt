// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdBotAddPromptToHistory : EntVdAutoStep() {
    var documentAttachment: StudioDtoArgValueParameter? = null
    var imageAttachment: StudioDtoArgValueParameter? = null
    var label: StudioBuildArgBinder? = null
    var promptField: StudioDtoArgValueParameter? = null
}
