// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.dto.StudioValueText

interface EntVdExpertAcquireLock : EntVdAutoStepWithError
{
  val duration: FieldDtoDuration?
  val lockKey: StudioValueText?
}