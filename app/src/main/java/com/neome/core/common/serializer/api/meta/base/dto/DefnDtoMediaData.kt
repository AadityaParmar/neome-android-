package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnDtoMedia
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.FieldDtoImage
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoMediaData(
    override val html: DefnDtoParagraph? = null,
    override val hyperlink: DefnDtoHyperLink? = null,
    override val image: FieldDtoImage? = null
) : DefnDtoMedia
