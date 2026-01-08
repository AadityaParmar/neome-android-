// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBuildUserSetting
import com.neome.api.meta.base.dto.StudioVar

interface StudioVarUserSetting : StudioVar
{
  val value: StudioBuildUserSetting?
}