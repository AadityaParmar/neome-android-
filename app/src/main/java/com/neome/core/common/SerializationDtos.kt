package com.neome.core.common

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessagePayloadImage
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.home.base.dto.DtoMessageReaction
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.home.main.sig.SigMessage
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.ContactId
import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.core.common.serializer.sysId.ContactIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

//enum class EnumKind1(val value: String) {
//    @SerialName("\$CreatedBy")
//    _CreatedBy("\$CreatedBy"),
//
//    @SerialName("header")
//    header_("header"),
//
//    @SerialName("name")
//    name_("name")
//
//}

enum class EnumKind(val value: String) {
    @SerialName("\$CreatedBy")
    CreatedBy("\$CreatedBy"),

    @SerialName("header")
    Header("header"),

    @SerialName("name")
    Name("name")
}


// derived classes
// Serializable sealed hierarchy for polymorphic deserialization

@Serializable
data class DefnDtoTextData(
    override var value: Array<String>?
) : DefnDtoText

@Serializable
sealed class DtoMessagePayloadSeal : DtoMessagePayload

@Serializable
data class DtoMessagePayloadTextData(
    override var isForwarded: Boolean? = null,
    override var mentionMap: Map<String, @Serializable(with = ContactIdSer::class) ContactId>? = null,
    override var messageType: EnumMessageType = EnumMessageType.text,
    override var isUpdated: Boolean? = null,
    override var text: String,
) : DtoMessagePayloadSeal(), DtoMessagePayloadText

@Serializable
data class DtoMessagePayloadImageData(
    override var isForwarded: Boolean? = null,
    override var mentionMap: Map<String, @Serializable(with = ContactIdSer::class) ContactId>? = null,
    override var messageType: EnumMessageType = EnumMessageType.image,
    override var isUpdated: Boolean? = null,
    override var text: String = "",
    override var fileSize: Long? = null,
    override var height: Long? = null,
    @Serializable(with = MediaIdImageSer::class)
    override var mediaIdBlurImage: MediaIdImage,
    @Serializable(with = MediaIdImageSer::class)
    override var mediaIdImage: MediaIdImage,
    override var primaryColor: String,
    override var width: Long? = null,
) : DtoMessagePayloadSeal(), DtoMessagePayloadImage

// Add more payload types as needed (audio, video, document, etc.)
@Serializable
data class DtoMessagePayloadAudioData(
    override val isForwarded: Boolean?,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) ContactId>?,
    override val messageType: EnumMessageType,
    override val isUpdated: Boolean?,
    override val text: String,
) : DtoMessagePayloadSeal(), DtoMessagePayloadText

@Serializable
data class SigMessageData(
    override var receiptStatus: EnumReceiptStatus? = null,
    override var version: String? = null,
    override var creationTime: String,
    override var isCallerSender: Boolean? = null,
    @Serializable(with = MessageIdSer::class)
    override var messageId: Types.MessageId,
    override var messageOffset: Long? = null,
    @Serializable(with = DtoMessagePayloadSerializer::class)
    override var payload: DtoMessagePayload,
    override val reactionMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, DtoMessageReaction>?,
    override val replyPayload: DtoMessageReplyPayload?,
    @Serializable(with = EntUserIdSer::class)
    override val senderId: Types.EntUserId
) : SigMessage


object DtoMessagePayloadSerializer : JsonContentPolymorphicSerializer<DtoMessagePayload>(
    DtoMessagePayload::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DtoMessagePayload> {
        val messageType = element.jsonObject["messageType"]?.jsonPrimitive?.content
        return when (messageType) {
            "text", EnumMessageType.text.value -> DtoMessagePayloadTextData.serializer()
            "image", EnumMessageType.image.value -> DtoMessagePayloadImageData.serializer()
            "audio", EnumMessageType.audio.value -> DtoMessagePayloadAudioData.serializer()
            else -> DtoMessagePayloadSeal.serializer() // Default fallback
        }
    }
}
