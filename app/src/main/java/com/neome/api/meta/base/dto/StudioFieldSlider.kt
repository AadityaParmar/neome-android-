// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioFieldCounter

interface StudioFieldSlider : StudioFieldCounter
{
  val allowRangePicker: Boolean?
  val showAsInputBox: Boolean?
}