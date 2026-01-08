// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

interface EntVdExecuteJavascript : EntVdAutoStepWithOutputAndError
{
  val outputForm: FormRefKey?
  val script: StudioValueCodeJavascript?
}