// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdBotHistoryRemove : EntVdAutoStep() {
    var historyIdField: StudioDtoArgValueParameter? = null
    var removeAll: Boolean? = null
    var retainCount: Number? = null
}
