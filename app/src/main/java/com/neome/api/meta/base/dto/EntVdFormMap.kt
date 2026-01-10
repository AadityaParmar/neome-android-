// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GhostId

interface EntVdFormMap : StudioBase {
    val keys: List<GhostId>
    val map: Map<GhostId, EntVdForm>
}
