// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnLayoutUserKind
import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.meta.base.Types.MetaIdRole

open class StudioDtoLayoutUser : StudioBase() {
    var allowToSwitchLayoutIdSet: Array<MetaIdLayoutUser>? = null
    var excludeRoleIdSet: Array<MetaIdRole>? = null
    var includeRoleIdSet: Array<MetaIdRole>? = null
    lateinit var kind: EnumDefnLayoutUserKind
    var label: String? = null
    lateinit var metaId: MetaIdLayoutUser
    lateinit var name: Symbol
    var showMyAssistantsOnly: Boolean? = null
}
