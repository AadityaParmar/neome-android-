// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw

class DtoWorkflowParameterInfo {
    var branchNodeId: MetaIdVdAutoNode? = null
    val form: DefnForm
    var formValue: FormValueRaw? = null
    var formValueLogTree: DtoLogTree? = null
    val name: string
    var paramId: MetaIdPipelineParam? = null
}
