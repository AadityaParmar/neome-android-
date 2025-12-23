// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioFieldImage

open class StudioFieldCamera : StudioFieldImage()
{
  var allowPickImage: Boolean? = null
  var captureLocation: Boolean? = null
  var captureTime: Boolean? = null
  var captureUser: Boolean? = null
  var pickImageRoleSet: Array<MetaIdRole>? = null
  var showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>? = null
}