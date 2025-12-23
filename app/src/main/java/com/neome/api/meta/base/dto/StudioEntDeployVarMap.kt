// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployVar

open class StudioEntDeployVarMap : StudioBase()
{
  lateinit var keys: Array<MetaIdVar>
  lateinit var map: Map<MetaIdVar, StudioEntDeployVar>
}