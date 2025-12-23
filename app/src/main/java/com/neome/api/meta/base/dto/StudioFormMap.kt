// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioForm

open class StudioFormMap : StudioBase()
{
  lateinit var keys: Array<MetaIdForm>
  lateinit var map: Map<MetaIdForm, StudioForm>
}