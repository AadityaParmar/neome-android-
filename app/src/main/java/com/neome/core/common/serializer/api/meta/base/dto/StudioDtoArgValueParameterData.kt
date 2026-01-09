package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioDtoArgValueField
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueParameterData(
    @Serializable(with = MetaIdCompositeSer::class) override val compositeId: Types.MetaIdComposite? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    override val valuePathArray: Array<String>? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val paramId: Types.MetaIdPipelineParam
) : StudioDtoArgValueParameter
