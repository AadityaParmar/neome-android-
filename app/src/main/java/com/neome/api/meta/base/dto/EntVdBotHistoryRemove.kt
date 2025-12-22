// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdBotHistoryRemove : EntVdAutoStep() {
    var historyIdField: StudioDtoArgValueParameter? = null
    var removeAll: boolean? = null
    var retainCount: number? = null
}
