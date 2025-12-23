// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdUserRemove : EntVdAutoStepWithError()
{
  var userIdField: StudioDtoArgValueParameter? = null
}