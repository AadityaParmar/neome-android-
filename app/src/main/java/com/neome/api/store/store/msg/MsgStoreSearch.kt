// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.nucleus.base.msg.Msg

class MsgStoreSearch : Msg() {
    var artifactKind: EnumStoreItemArtifact? = null
    var filterStoreItemIdSet: StoreItemId[]? = null
    val query: string
    val searchId: string
    var storeLabelSet: EnumStoreLabel[]? = null
}
