// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAiWithOutput
import com.neome.api.meta.base.dto.FormRefKey

open class EntVdAiFakerToForm : EntVdAiWithOutput()
{
  var outputForm: FormRefKey? = null
}