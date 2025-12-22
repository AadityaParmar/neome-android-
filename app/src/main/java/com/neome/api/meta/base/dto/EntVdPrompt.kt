// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GhostId

class EntVdPrompt : StudioBase() {
    val metaId: GhostId
    var prompt: StudioValueCodeJavascript? = null
    var promptForm: FormRefKey? = null
}
