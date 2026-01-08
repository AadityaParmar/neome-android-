// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnCaptureMode
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.dto.FieldDtoLocation
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldLocation : DefnFieldEditable
{
  val captureMode: EnumDefnCaptureMode?
  val captureTime: Boolean?
  val captureUser: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: FieldDtoLocation?
  val defaultVar: FieldDtoLocation?
  val showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>?
  val showProgressBar: Boolean?
}