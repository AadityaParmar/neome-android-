// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoNode
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdUserHasRoles : EntVdAutoNode()
{
  var roleField: StudioDtoArgValueParameter? = null
  var user: StudioBuildArgBinder? = null
}