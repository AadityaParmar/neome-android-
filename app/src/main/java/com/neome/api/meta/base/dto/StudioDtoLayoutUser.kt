// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnLayoutUserKind
import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.meta.base.Types.MetaIdRole

class StudioDtoLayoutUser : StudioBase() {
    var allowToSwitchLayoutIdSet: MetaIdLayoutUser[]? = null
    var excludeRoleIdSet: MetaIdRole[]? = null
    var includeRoleIdSet: MetaIdRole[]? = null
    val kind: EnumDefnLayoutUserKind
    var label: string? = null
    val metaId: MetaIdLayoutUser
    val name: Symbol
    var showMyAssistantsOnly: boolean? = null
}
