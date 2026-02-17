// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutUser

interface StudioMapOfLayoutUser : StudioBase
{
  val keys: List<MetaIdLayoutUser>
  val map: Map<MetaIdLayoutUser, StudioDtoLayoutUser>
  val mobileDefaultLayoutId: MetaIdLayoutUser?
  val webDefaultLayoutId: MetaIdLayoutUser?
}