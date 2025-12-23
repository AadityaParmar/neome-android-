// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GhostId

open class EntVdForm : StudioBase() {
    var form: FormRefKey? = null
    lateinit var metaId: GhostId
}
