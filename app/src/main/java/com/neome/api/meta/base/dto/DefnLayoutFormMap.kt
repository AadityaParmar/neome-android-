// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutForm
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutForm

open class DefnLayoutFormMap
{
  var asideDefaultLayoutId: MetaIdLayoutForm? = null
  lateinit var keys: Array<MetaIdLayoutForm>
  lateinit var map: Map<MetaIdLayoutForm, DefnLayoutForm>
  var mobileDefaultLayoutId: MetaIdLayoutForm? = null
}