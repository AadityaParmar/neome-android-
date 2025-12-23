// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

open class StudioDtoOptionPermission : StudioBase()
{
  lateinit var metaId: MetaIdRole
  var name: Symbol? = null
  lateinit var optionIdSet: Array<String>
}