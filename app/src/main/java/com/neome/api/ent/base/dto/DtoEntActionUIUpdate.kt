// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindActionUIUpdate
import com.neome.api.meta.base.Types.MetaIdGroup

open class DtoEntActionUIUpdate : DtoEntAction() {
    var groupId: MetaIdGroup? = null
    lateinit var updateKind: EnumDefnKindActionUIUpdate
}
