// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutForm

interface StudioMapOfLayoutForm : StudioBase
{
  val asideDefaultLayoutId: MetaIdLayoutForm?
  val keys: Array<MetaIdLayoutForm>
  val map: Map<MetaIdLayoutForm, StudioDtoLayoutForm>
  val mobileDefaultLayoutId: MetaIdLayoutForm?
}