// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoChatBadgeMap
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.SigVersion

class SigBadgeMap : SigVersion() {
    val entChatBadgeMap: Record<EntId, DtoChatBadgeMap>
}
