// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioFieldCounter

open class StudioFieldSlider : StudioFieldCounter()
{
  var allowRangePicker: Boolean? = null
  var showAsInputBox: Boolean? = null
}