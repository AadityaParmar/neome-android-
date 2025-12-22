// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindActionUIUpdate
import com.neome.api.meta.base.Types.MetaIdGroup

class StudioEntActionUIUpdate : StudioEntAction() {
    var groupId: MetaIdGroup? = null
    var updateKind: EnumDefnKindActionUIUpdate? = null
}
