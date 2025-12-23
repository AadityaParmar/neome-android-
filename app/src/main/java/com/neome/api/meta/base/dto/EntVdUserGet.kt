// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.dto.StudioBuildArgBinder

open class EntVdUserGet : EntVdAutoStepWithOutputAndError()
{
  var user: StudioBuildArgBinder? = null
}