package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoWorkflowParameterInfo
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.DtoLogTreeData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoWorkflowParameterInfoData(
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val branchNodeId: Types.MetaIdVdAutoNode? = null,
    override val form: DefnFormData,
    override val formValue: FormValueRawData? = null,
    override val formValueLogTree: DtoLogTreeData? = null,
    override val name: String,
    @Serializable(with = MetaIdPipelineParamSer::class) override val paramId: Types.MetaIdPipelineParam? = null
) : DtoWorkflowParameterInfo
