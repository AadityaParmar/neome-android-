// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldSignature : StudioFieldEditable
{
  val captureLocation: Boolean?
  val captureTime: Boolean?
  val captureUser: Boolean?
  val showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>?
}