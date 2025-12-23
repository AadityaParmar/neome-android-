// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter

open class EntVdUserAdd : EntVdAutoStepWithError()
{
  var outputField: StudioDtoArgValueParameter? = null
  var userHandleField: StudioDtoArgValueParameter? = null
  var userManager: StudioDtoUserFilter? = null
  var userNameField: StudioDtoArgValueParameter? = null
  var userRoles: StudioBuildArgBinder? = null
}