// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdVdAutoFunc

interface EntVdApplyTransforms : EntVdAutoStep
{
  val keys: Array<MetaIdVdAutoFunc>
  val map: Map<MetaIdVdAutoFunc, AutoXform>
}