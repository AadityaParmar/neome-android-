package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumWhatsAppTemplateHeaderType
import com.neome.api.meta.base.dto.DtoCarouselTemplateGroup
import com.neome.api.meta.base.dto.DtoWhatsAppTemplateGroup
import kotlinx.serialization.Serializable


@Serializable
data class DtoWhatsAppTemplateGroupData(
    override val carouselCardFormat: String? = null,
    override val carouselCardSample: String? = null,
    override val carouselTemplateGroup: DtoCarouselTemplateGroup? = null,
    override val format: String,
    override val groupId: String,
    override val groupName: String,
    override val isCarouselTemplate: Boolean,
    override val numberOfButtonParams: Long? = null,
    override val numberOfParams: Long? = null,
    override val sample: String,
    override val supportedHeaders: Array<EnumWhatsAppTemplateHeaderType>
) : DtoWhatsAppTemplateGroup
