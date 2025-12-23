// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.EntVdAutoStep
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVdAutoFunc

open class EntVdApplyTransforms : EntVdAutoStep()
{
  lateinit var keys: Array<MetaIdVdAutoFunc>
  lateinit var map: Map<MetaIdVdAutoFunc, AutoXform>
}