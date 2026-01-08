// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface EntVdBotAddPromptToHistory : EntVdAutoStep
{
  val documentAttachment: StudioDtoArgValueParameter?
  val imageAttachment: StudioDtoArgValueParameter?
  val label: StudioBuildArgBinder?
  val promptField: StudioDtoArgValueParameter?
}