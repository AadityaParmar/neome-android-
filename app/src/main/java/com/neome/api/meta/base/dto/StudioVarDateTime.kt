// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBuildDateTime
import com.neome.api.meta.base.dto.StudioVar

open class StudioVarDateTime : StudioVar()
{
  var value: StudioBuildDateTime? = null
}