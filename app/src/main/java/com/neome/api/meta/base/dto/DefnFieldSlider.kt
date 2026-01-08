// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldCounter

interface DefnFieldSlider : DefnFieldCounter
{
  val allowRangePicker: Boolean?
  val showAsInputBox: Boolean?
}