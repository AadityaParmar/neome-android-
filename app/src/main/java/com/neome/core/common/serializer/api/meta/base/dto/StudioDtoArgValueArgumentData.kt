package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnArgBinderArgument
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.api.meta.base.dto.StudioDtoArgValueArgument
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueArgumentData(
    override val arg1: EnumDefnArgBinderArgument,
    override val arg2: EnumDefnArgBinderArgument? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    override val valuePathArray: Array<String>? = null
) : StudioDtoArgValueArgument
