package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoWorkflowParameterInfo
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoWorkflowParameterInfoData(
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val branchNodeId: Types.MetaIdVdAutoNode? = null,
    override val form: DefnForm,
    override val formValue: FormValueRaw? = null,
    override val formValueLogTree: DtoLogTree? = null,
    override val name: String,
    @Serializable(with = MetaIdPipelineParamSer::class) override val paramId: Types.MetaIdPipelineParam? = null
) : DtoWorkflowParameterInfo
