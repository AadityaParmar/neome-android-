// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTree
import com.neome.api.meta.base.dto.StudioBase

open class StudioBuildTree : StudioBase()
{
  lateinit var dtoTree: FieldDtoTree
}