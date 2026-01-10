// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdAction

interface DtoEntGroupActionPermissionMap {
    val defaultActionId: MetaIdAction?
    val defaultPinnedActionIdSet: List<MetaIdAction>?
    val hideActionMenu: Boolean?
    val keys: List<MetaIdAction>
    val map: Map<MetaIdAction, DtoEntActionPermission>
    val mobilePinnedActionIdSet: List<MetaIdAction>?
}
