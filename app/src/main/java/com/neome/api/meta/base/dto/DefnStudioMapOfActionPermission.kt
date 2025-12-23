// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import java.util.Map

open class DefnStudioMapOfActionPermission {
    lateinit var keys: Array<MetaIdAction>
    lateinit var map: Map<MetaIdAction, DefnStudioDtoActionPermission>
}
