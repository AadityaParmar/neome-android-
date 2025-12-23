// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.dto.StudioEnt
import com.neome.api.nucleus.base.msg.Msg

open class MsgStudioEntMerge : Msg() {
    lateinit var storeItemIdSet: Array<StoreItemId>
    lateinit var studioEnt: StudioEnt
}
