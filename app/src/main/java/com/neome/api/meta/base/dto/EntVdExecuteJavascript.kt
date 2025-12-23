// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

open class EntVdExecuteJavascript : EntVdAutoStepWithOutputAndError()
{
  var outputForm: FormRefKey? = null
  var script: StudioValueCodeJavascript? = null
}