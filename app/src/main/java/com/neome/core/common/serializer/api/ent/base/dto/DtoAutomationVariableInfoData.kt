package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAutomationVariableInfo
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.DtoLogTreeData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoAutomationVariableInfoData(
    override val form: DefnFormData,
    override val formValue: FormValueRawData? = null,
    override val formValueLogTree: DtoLogTreeData? = null,
    override val name: String,
    @Serializable(with = MetaIdPipelineParamSer::class) override val pipelineVarId: Types.MetaIdPipelineParam? = null
) : DtoAutomationVariableInfo
