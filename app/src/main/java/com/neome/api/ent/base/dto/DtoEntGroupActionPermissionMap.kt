// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdAction

class DtoEntGroupActionPermissionMap {
    var defaultActionId: MetaIdAction? = null
    var defaultPinnedActionIdSet: MetaIdAction[]? = null
    var hideActionMenu: boolean? = null
    val keys: MetaIdAction[]
    val map: Record<MetaIdAction, DtoEntActionPermission>
    var mobilePinnedActionIdSet: MetaIdAction[]? = null
}
