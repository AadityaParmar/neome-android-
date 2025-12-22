// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

class DtoWorkflowDebugConfig {
    val breakpointMap: Record<MetaIdVdAutoDia, MetaIdVdAutoNode[]>
    var defaultDebugEntUserId: EntUserId? = null
}
