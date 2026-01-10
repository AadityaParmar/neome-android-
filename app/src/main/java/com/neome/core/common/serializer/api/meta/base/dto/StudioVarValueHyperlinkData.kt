package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioVarValueHyperlink
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueHyperlinkData(
    override val color: StudioDtoColorData? = null,
    @Serializable(with = MetaIdVarSer::class) override val colorVarId: Types.MetaIdVar? = null,
    override val displayText: String? = null,
    override val kind: EnumDefnKindHyperlink? = null,
    override val value: String? = null
) : StudioVarValueHyperlink
