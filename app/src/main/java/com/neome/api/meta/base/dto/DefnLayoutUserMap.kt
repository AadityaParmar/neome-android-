// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutUser
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutUser

interface DefnLayoutUserMap
{
  val keys: Array<MetaIdLayoutUser>
  val map: Map<MetaIdLayoutUser, DefnLayoutUser>
  val mobileDefaultLayoutId: MetaIdLayoutUser?
  val webDefaultLayoutId: MetaIdLayoutUser?
}