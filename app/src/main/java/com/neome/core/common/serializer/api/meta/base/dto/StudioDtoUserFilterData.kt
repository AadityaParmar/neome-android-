package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoUserFilterData(
    @Serializable(with = MetaIdPipelineParamSer::class) override val userPipelineParamId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = MetaIdVarSer::class) override val userVarId: Types.MetaIdVar? = null,
    override val users: StudioBuildArgBinder? = null
) : StudioDtoUserFilter
