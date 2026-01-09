package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnLayoutFormHeader
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.sysId.MetaIdHyperlinkSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormHeaderData(
    override val backgroundColor: DefnDtoColor? = null,
    override val backgroundColorVar: DefnDtoColor? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formLayoutId: Types.MetaIdLayoutForm? = null,
    override val headerImage: FieldDtoImage? = null,
    override val headerImageHeight: Long? = null,
    override val headerImageVar: FieldDtoImage? = null,
    override val hyperLinkMap: Map<@Serializable(with = MetaIdHyperlinkSer::class) Types.MetaIdHyperlink, DefnDtoHyperLink>? = null,
    override val hyperlinkKeys: Array<@Serializable(with = MetaIdHyperlinkSer::class) Types.MetaIdHyperlink>? = null,
    override val showEnterprise: Boolean? = null,
    override val showSeparator: Boolean? = null,
    override val textColor: DefnDtoColor? = null,
    override val textColorVar: DefnDtoColor? = null
) : DefnLayoutFormHeader
