// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.main.sig.SigMessage
import com.neome.api.nucleus.base.sig.SigVersion

class SigAsideSearch : SigVersion() {
    val messageList: SigMessage[]
    val totalMessageCount: number
}
