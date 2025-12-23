// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutUser
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutUser

open class DefnLayoutUserMap
{
  lateinit var keys: Array<MetaIdLayoutUser>
  lateinit var map: Map<MetaIdLayoutUser, DefnLayoutUser>
  var mobileDefaultLayoutId: MetaIdLayoutUser? = null
  var webDefaultLayoutId: MetaIdLayoutUser? = null
}