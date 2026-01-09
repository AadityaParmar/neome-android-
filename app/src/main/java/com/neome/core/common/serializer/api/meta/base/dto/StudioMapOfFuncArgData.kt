package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFuncArg
import com.neome.api.meta.base.dto.StudioMapOfFuncArg
import com.neome.core.common.serializer.sysId.MetaIdFuncArgSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfFuncArgData(
    override val keys: Array<@Serializable(with = MetaIdFuncArgSer::class) Types.MetaIdFuncArg>? = null,
    override val map: Map<@Serializable(with = MetaIdFuncArgSer::class) Types.MetaIdFuncArg, StudioDtoFuncArg>
) : StudioMapOfFuncArg
