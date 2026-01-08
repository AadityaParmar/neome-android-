// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployVar

interface StudioEntDeployVarMap : StudioBase
{
  val keys: Array<MetaIdVar>
  val map: Map<MetaIdVar, StudioEntDeployVar>
}