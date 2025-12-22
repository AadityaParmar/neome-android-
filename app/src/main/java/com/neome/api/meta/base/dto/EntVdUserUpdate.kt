// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdUserUpdate : EntVdAutoStepWithError() {
    var userActivateField: StudioBuildArgBinder? = null
    var userIdField: StudioDtoArgValueParameter? = null
    var userManager: StudioDtoUserFilter? = null
    var userNameField: StudioDtoArgValueParameter? = null
    var userRoles: StudioBuildArgBinder? = null
}
