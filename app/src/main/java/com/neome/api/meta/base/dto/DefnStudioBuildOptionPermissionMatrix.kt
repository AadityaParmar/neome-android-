// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoOption
import com.neome.api.meta.base.dto.DefnField

open class DefnStudioBuildOptionPermissionMatrix : DefnField()
{
  var optionSet: Array<DefnDtoOption>? = null
}