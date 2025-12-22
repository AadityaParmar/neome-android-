// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoEdge
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

class EntVdAutoDia : EntVdDia() {
    var description: string? = null
    val edgeMap: Record<MetaIdVdAutoEdge, EntVdAutoEdge>
    var label: string? = null
    val metaId: MetaIdVdAutoDia
    val name: Symbol
    val nodeMap: Record<MetaIdVdAutoNode, EntVdAutoNode>
}
