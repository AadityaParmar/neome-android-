// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind

interface DefnFieldScanCode : DefnFieldEditable
{
  val barCode: Boolean?
  val captureLocation: Boolean?
  val captureTime: Boolean?
  val captureUser: Boolean?
  val qrCode: Boolean?
  val showCapturedValuesOnAside: List<EnumDefnCaptureValueKind>?
}