package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdHyperlinkSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoHyperLinkData(
    override val color: DefnDtoColorData? = null,
    override val colorVar: DefnDtoColorData? = null,
    override val displayText: String? = null,
    override val kind: EnumDefnKindHyperlink? = null,
    @Serializable(with = MetaIdHyperlinkSer::class) override val metaId: Types.MetaIdHyperlink,
    override val value: String? = null
) : DefnDtoHyperLink
