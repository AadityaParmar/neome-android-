// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioValueText

open class EntVdExpertResume : EntVdAutoStep()
{
  var option: StudioBuildArgBinder? = null
  var pauseKey: StudioValueText? = null
}