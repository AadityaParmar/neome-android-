// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityAction
import java.util.Map

open class DefnVisibilityActionMap {
    lateinit var keys: Array<MetaIdVisibilityAction>
    lateinit var map: Map<MetaIdVisibilityAction, DefnVisibilityAction>
}
