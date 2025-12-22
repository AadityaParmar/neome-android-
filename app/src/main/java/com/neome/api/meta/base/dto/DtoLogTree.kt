// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class DtoLogTree : DtoLogItem() {
    val bgColor: string
    var children: DtoLogTreeItem[]? = null
    val keyColor: string
    val keyWidth: number
    val lineColor: string
    val tabWidth: number
    val valueColor: string
}
