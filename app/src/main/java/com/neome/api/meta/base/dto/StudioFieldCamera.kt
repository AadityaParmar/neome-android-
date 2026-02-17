// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioFieldImage

interface StudioFieldCamera : StudioFieldImage
{
  val allowPickImage: Boolean?
  val captureLocation: Boolean?
  val captureTime: Boolean?
  val captureUser: Boolean?
  val pickImageRoleSet: List<MetaIdRole>?
  val showCapturedValuesOnAside: List<EnumDefnCaptureValueKind>?
}