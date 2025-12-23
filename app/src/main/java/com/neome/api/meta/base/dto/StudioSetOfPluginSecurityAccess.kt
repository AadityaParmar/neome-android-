// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginSecurityAccess
import com.neome.api.meta.base.dto.StudioBase

open class StudioSetOfPluginSecurityAccess : StudioBase()
{
  lateinit var valueSet: Array<EnumDefnPluginSecurityAccess>
}