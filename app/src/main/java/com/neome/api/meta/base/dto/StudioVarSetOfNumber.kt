// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioSetOfNumber
import com.neome.api.meta.base.dto.StudioVar

interface StudioVarSetOfNumber : StudioVar
{
  val value: StudioSetOfNumber?
}