// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAi
import com.neome.api.meta.base.dto.EntVdFormMap
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdBranchSwitchForm : EntVdAi()
{
  var field: StudioDtoArgValueParameter? = null
  var formMap: EntVdFormMap? = null
}