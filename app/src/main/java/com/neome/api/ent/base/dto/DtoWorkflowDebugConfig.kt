// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import java.util.Map

open class DtoWorkflowDebugConfig {
    lateinit var breakpointMap: Map<MetaIdVdAutoDia, Array<MetaIdVdAutoNode>>
    var defaultDebugEntUserId: EntUserId? = null
}
