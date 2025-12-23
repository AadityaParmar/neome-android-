// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

open class DtoGridLayoutRefKey
{
  lateinit var gridId: MetaIdGrid
  lateinit var layoutGridId: MetaIdLayoutGrid
}