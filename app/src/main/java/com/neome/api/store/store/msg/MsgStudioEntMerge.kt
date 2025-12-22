// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.dto.StudioEnt
import com.neome.api.nucleus.base.msg.Msg

class MsgStudioEntMerge : Msg() {
    val storeItemIdSet: StoreItemId[]
    val studioEnt: StudioEnt
}
