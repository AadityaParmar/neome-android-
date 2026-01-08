// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Symbol

interface DefnLayoutForm
{
  val metaId: MetaIdLayoutForm
  val name: Symbol
  val type: EnumDefnFormLayoutType?
}