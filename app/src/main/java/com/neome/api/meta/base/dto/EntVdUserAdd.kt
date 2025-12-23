// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdUserAdd : EntVdAutoStepWithError() {
    var outputField: StudioDtoArgValueParameter? = null
    var userHandleField: StudioDtoArgValueParameter? = null
    var userManager: StudioDtoUserFilter? = null
    var userNameField: StudioDtoArgValueParameter? = null
    var userRoles: StudioBuildArgBinder? = null
}
