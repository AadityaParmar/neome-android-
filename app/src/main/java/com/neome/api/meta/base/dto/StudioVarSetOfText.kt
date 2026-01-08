// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioMapOfOption
import com.neome.api.meta.base.dto.StudioVar

interface StudioVarSetOfText : StudioVar
{
  val value: StudioMapOfOption?
}