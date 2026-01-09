package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoTableStyle
import com.neome.api.meta.base.dto.DefnMapOfTableStyle
import com.neome.core.common.serializer.sysId.MetaIdTableStyleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnMapOfTableStyleData(
    override val keys: Array<@Serializable(with = MetaIdTableStyleSer::class) Types.MetaIdTableStyle>? = null,
    override val map: Map<@Serializable(with = MetaIdTableStyleSer::class) Types.MetaIdTableStyle, DefnDtoTableStyle>
) : DefnMapOfTableStyle
