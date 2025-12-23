// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates

open class DtoLogTree : DtoLogItem() {
    lateinit var bgColor: String
    var children: Array<DtoLogTreeItem>? = null
    lateinit var keyColor: String
    var keyWidth: Number by Delegates.notNull<Number>()
    lateinit var lineColor: String
    var tabWidth: Number by Delegates.notNull<Number>()
    lateinit var valueColor: String
}
