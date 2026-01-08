// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioFieldSwitch : StudioFieldEditable
{
  val captureLocation: Boolean?
  val captureTime: Boolean?
  val captureUser: Boolean?
  val checkboxLabelVarId: StudioValueVarIdText?
  val defaultFieldId: MetaIdField?
  val defaultValue: Boolean?
  val defaultVarId: MetaIdVar?
  val labelPlacement: EnumDefnPlacement?
  val labelPlacementVarId: MetaIdVar?
  val position: EnumDefnPlacement?
  val positionVarId: MetaIdVar?
  val showAsCheckbox: Boolean?
  val showAsCheckboxFieldId: MetaIdField?
  val showAsCheckboxVarId: MetaIdVar?
  val showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>?
}