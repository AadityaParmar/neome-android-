// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioMapOfText
import com.neome.api.meta.base.dto.StudioVar

interface StudioVarMapOfText : StudioVar
{
  val value: StudioMapOfText?
}