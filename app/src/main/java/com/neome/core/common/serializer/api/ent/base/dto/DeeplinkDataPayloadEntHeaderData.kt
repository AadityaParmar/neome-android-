package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadEntHeaderData(
    override val hyperLinkSet: Array<DefnDtoHyperLink>? = null,
    override val showEnterprise: Boolean? = null,
    override val showHeader: Boolean? = null,
    override val showSeparator: Boolean? = null
) : DeeplinkDataPayloadEntHeader
