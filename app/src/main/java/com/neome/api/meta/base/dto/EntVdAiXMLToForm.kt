// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAiWithOutput
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdAiXMLToForm : EntVdAiWithOutput()
{
  var inputField: StudioDtoArgValueParameter? = null
  var outputForm: FormRefKey? = null
}