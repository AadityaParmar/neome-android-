// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.dto.StudioBase

open class EntVdWorkflowPointer : StudioBase()
{
  var autoDiaId: MetaIdVdAutoDia? = null
  var startNodeId: MetaIdVdAutoNode? = null
}