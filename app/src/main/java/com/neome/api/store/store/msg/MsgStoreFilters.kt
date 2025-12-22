// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.nucleus.base.msg.Msg

class MsgStoreFilters : Msg() {
    var artifactKindSet: EnumStoreItemArtifact[]? = null
    var storeLabelSet: EnumStoreLabel[]? = null
}
