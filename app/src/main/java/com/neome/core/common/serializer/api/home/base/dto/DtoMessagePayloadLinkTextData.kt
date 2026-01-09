package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayloadLinkText
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ContactIdSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DtoMessagePayloadLinkTextSeal : DtoMessagePayloadLinkText


@Serializable
data class DtoMessagePayloadLinkTextData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType,
    override val isUpdated: Boolean? = null,
    override val text: String,
    override val pageIconUrl: String? = null,
    override val pageSubTitle: String? = null,
    override val pageTitle: String? = null,
    override val pageUrl: String
) : DtoMessagePayloadSeal, DtoMessagePayloadLinkText
