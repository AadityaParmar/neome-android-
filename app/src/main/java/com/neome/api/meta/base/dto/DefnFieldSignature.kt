// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind

open class DefnFieldSignature : DefnFieldEditable()
{
  var captureLocation: Boolean? = null
  var captureTime: Boolean? = null
  var captureUser: Boolean? = null
  var showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>? = null
}