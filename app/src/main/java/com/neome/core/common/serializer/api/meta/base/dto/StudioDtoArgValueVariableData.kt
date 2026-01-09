package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.api.meta.base.dto.StudioDtoArgValueVariable
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueVariableData(
    override val valuePathArray: Array<String>? = null,
    @Serializable(with = MetaIdVarSer::class) override val varId: Types.MetaIdVar
) : StudioDtoArgValueVariable
