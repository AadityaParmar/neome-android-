// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw

open class DtoAutomationVariableInfo {
    lateinit var form: DefnForm
    var formValue: FormValueRaw? = null
    var formValueLogTree: DtoLogTree? = null
    lateinit var name: String
    var pipelineVarId: MetaIdPipelineParam? = null
}
