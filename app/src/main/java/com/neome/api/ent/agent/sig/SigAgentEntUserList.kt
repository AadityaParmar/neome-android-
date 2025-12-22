// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.ent.base.dto.DtoAgentEntUser
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.sig.SigVersion

class SigAgentEntUserList : SigVersion() {
    val entUserMap: Record<EntUserId, DtoAgentEntUser>
}
