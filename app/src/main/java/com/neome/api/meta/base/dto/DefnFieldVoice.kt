// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldVoice : DefnFieldEditable
{
  val captureLocation: Boolean?
  val captureTime: Boolean?
  val captureUser: Boolean?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVar: Long?
  val showCapturedValuesOnAside: List<EnumDefnCaptureValueKind>?
}