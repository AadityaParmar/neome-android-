package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoSwimlane
import com.neome.core.common.serializer.sysId.MetaIdSwimlaneSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoSwimlaneData(
    override val color: DefnDtoColor? = null,
    override val colorVar: DefnDtoColor? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdSwimlaneSer::class) override val metaId: Types.MetaIdSwimlane,
    override val valueOptionId: String? = null
) : DefnDtoSwimlane
