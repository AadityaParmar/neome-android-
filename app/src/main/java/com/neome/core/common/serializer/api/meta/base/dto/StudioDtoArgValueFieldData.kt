package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.api.meta.base.dto.StudioDtoArgValueField
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueFieldData(
    @Serializable(with = MetaIdCompositeSer::class) override val compositeId: Types.MetaIdComposite? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    override val valuePathArray: Array<String>? = null
) : StudioDtoArgValueField
