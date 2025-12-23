// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutUser

open class StudioMapOfLayoutUser : StudioBase()
{
  lateinit var keys: Array<MetaIdLayoutUser>
  lateinit var map: Map<MetaIdLayoutUser, StudioDtoLayoutUser>
  var mobileDefaultLayoutId: MetaIdLayoutUser? = null
  var webDefaultLayoutId: MetaIdLayoutUser? = null
}