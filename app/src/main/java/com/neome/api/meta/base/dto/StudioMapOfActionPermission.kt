// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction

interface StudioMapOfActionPermission : StudioBase {
    val keys: List<MetaIdAction>
    val map: Map<MetaIdAction, StudioDtoActionPermission>
}
