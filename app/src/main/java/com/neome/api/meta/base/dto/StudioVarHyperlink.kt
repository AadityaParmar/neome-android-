// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarValueHyperlink

open class StudioVarHyperlink : StudioVar()
{
  var value: StudioVarValueHyperlink? = null
}