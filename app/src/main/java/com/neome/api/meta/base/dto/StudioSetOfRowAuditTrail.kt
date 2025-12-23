// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRowAuditTrail
import com.neome.api.meta.base.dto.StudioBase

open class StudioSetOfRowAuditTrail : StudioBase()
{
  lateinit var valueSet: Array<EnumDefnRowAuditTrail>
}