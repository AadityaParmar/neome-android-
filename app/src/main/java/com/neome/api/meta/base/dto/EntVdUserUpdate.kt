// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoUserFilter

interface EntVdUserUpdate : EntVdAutoStepWithError
{
  val userActivateField: StudioBuildArgBinder?
  val userIdField: StudioDtoArgValueParameter?
  val userManager: StudioDtoUserFilter?
  val userNameField: StudioDtoArgValueParameter?
  val userRoles: StudioBuildArgBinder?
}