// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginSecurityAccess

interface StudioSetOfPluginSecurityAccess : StudioBase {
    val valueSet: List<EnumDefnPluginSecurityAccess>
}
