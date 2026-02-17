// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnKindAutomation

interface DefnStudioPickAutomationId : DefnField
{
  val filterAutomationKindSet: List<EnumDefnKindAutomation>?
}