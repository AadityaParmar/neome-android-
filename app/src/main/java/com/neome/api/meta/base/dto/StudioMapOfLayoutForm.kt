// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindFormRenderingMode
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutForm

interface StudioMapOfLayoutForm : StudioBase
{
  val asideDefaultLayoutId: MetaIdLayoutForm?
  val keys: List<MetaIdLayoutForm>
  val map: Map<MetaIdLayoutForm, StudioDtoLayoutForm>
  val mobileDefaultLayoutId: MetaIdLayoutForm?
  val renderingModeKind: EnumDefnKindFormRenderingMode?
}