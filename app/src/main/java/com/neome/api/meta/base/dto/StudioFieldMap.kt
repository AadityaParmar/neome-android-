// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioField

interface StudioFieldMap : StudioBase
{
  val keys: Array<MetaIdField>
  val map: Map<MetaIdField, StudioField>
}