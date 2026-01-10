package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnLayoutFormHeader
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoHyperLinkData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.sysId.MetaIdHyperlinkSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormHeaderData(
    override val backgroundColor: DefnDtoColorData? = null,
    override val backgroundColorVar: DefnDtoColorData? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formLayoutId: Types.MetaIdLayoutForm? = null,
    override val headerImage: FieldDtoImageData? = null,
    override val headerImageHeight: Long? = null,
    override val headerImageVar: FieldDtoImageData? = null,
    override val hyperLinkMap: Map<@Serializable(with = MetaIdHyperlinkSer::class) Types.MetaIdHyperlink, DefnDtoHyperLinkData>? = null,
    override val hyperlinkKeys: List<@Serializable(with = MetaIdHyperlinkSer::class) Types.MetaIdHyperlink>? = null,
    override val showEnterprise: Boolean? = null,
    override val showSeparator: Boolean? = null,
    override val textColor: DefnDtoColorData? = null,
    override val textColorVar: DefnDtoColorData? = null
) : DefnLayoutFormHeader
