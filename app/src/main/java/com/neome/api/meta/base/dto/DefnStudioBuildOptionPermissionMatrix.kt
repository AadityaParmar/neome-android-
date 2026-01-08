// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoOption
import com.neome.api.meta.base.dto.DefnField

interface DefnStudioBuildOptionPermissionMatrix : DefnField
{
  val optionSet: Array<DefnDtoOption>?
}