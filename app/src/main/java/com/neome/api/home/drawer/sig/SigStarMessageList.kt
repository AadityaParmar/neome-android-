// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoStarMessage
import com.neome.api.nucleus.base.sig.SigVersion

class SigStarMessageList : SigVersion() {
    val starMessageList: DtoStarMessage[]
}
