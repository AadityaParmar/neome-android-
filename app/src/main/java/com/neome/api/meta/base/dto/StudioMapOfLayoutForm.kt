// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutForm

open class StudioMapOfLayoutForm : StudioBase()
{
  var asideDefaultLayoutId: MetaIdLayoutForm? = null
  lateinit var keys: Array<MetaIdLayoutForm>
  lateinit var map: Map<MetaIdLayoutForm, StudioDtoLayoutForm>
  var mobileDefaultLayoutId: MetaIdLayoutForm? = null
}