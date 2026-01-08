// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoNode
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface EntVdUserIsGrandManager : EntVdAutoNode
{
  val grandManagerField: StudioDtoArgValueParameter?
  val user: StudioBuildArgBinder?
}