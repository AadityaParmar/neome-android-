package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnDtoMedia
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoHyperLinkData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoMediaData(
    override val html: DefnDtoParagraphData? = null,
    override val hyperlink: DefnDtoHyperLinkData? = null,
    override val image: FieldDtoImageData? = null
) : DefnDtoMedia
