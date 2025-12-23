// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoArgValue

open class StudioDtoArgValueInput : StudioDtoArgValue()
{
  var compositeId: MetaIdComposite? = null
  lateinit var fieldId: MetaIdField
  var valuePathArray: Array<String>? = null
}