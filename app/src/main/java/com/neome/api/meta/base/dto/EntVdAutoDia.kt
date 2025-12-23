// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoEdge
import com.neome.api.meta.base.dto.EntVdAutoNode
import com.neome.api.meta.base.dto.EntVdDia
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoEdge
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.Symbol

open class EntVdAutoDia : EntVdDia()
{
  var description: String? = null
  lateinit var edgeMap: Map<MetaIdVdAutoEdge, EntVdAutoEdge>
  var label: String? = null
  lateinit var metaId: MetaIdVdAutoDia
  lateinit var name: Symbol
  lateinit var nodeMap: Map<MetaIdVdAutoNode, EntVdAutoNode>
}