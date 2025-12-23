// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldCounter

open class DefnFieldSlider : DefnFieldCounter()
{
  var allowRangePicker: Boolean? = null
  var showAsInputBox: Boolean? = null
}