package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessagePayloadDocument
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ContactIdSer
import com.neome.core.common.serializer.sysId.MediaIdDocumentSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DtoMessagePayloadDocumentSeal : DtoMessagePayloadDocument


@Serializable
data class DtoMessagePayloadDocumentData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType = EnumMessageType.document,
    override val fileExt: String,
    override val fileName: String,
    override val fileSize: Long? = null,
    @Serializable(with = MediaIdDocumentSer::class) override val mediaIdDocument: Types.MediaIdDocument
) : DtoMessagePayloadSeal, DtoMessagePayloadDocument
