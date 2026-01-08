// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoEdge
import com.neome.api.meta.base.dto.EntVdAutoNode
import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoEdge
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.Symbol

interface EntVdAutoDia : EntVdDia
{
  val description: String?
  val edgeMap: Map<MetaIdVdAutoEdge, EntVdAutoEdge>
  val label: String?
  val metaId: MetaIdVdAutoDia
  val name: Symbol
  val nodeMap: Map<MetaIdVdAutoNode, EntVdAutoNode>
}