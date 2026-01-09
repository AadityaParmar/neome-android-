package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnFuncArg
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFuncArg
import com.neome.core.common.serializer.sysId.MetaIdFuncArgSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoFuncArgData(
    override val funcArgKind: EnumDefnFuncArg? = null,
    @Serializable(with = MetaIdFuncArgSer::class) override val metaId: Types.MetaIdFuncArg,
    override val name: String,
    override val required: Boolean? = null
) : StudioDtoFuncArg
