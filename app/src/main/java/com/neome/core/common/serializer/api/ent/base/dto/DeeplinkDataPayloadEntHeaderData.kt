package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoHyperLinkData
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadEntHeaderData(
    override val hyperLinkSet: List<DefnDtoHyperLinkData>? = null,
    override val showEnterprise: Boolean? = null,
    override val showHeader: Boolean? = null,
    override val showSeparator: Boolean? = null
) : DeeplinkDataPayloadEntHeader
