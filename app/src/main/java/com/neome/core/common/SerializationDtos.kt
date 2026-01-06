package com.neome.core.common

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.ContactId
import com.neome.api.meta.base.Types.MediaIdImage
import kotlinx.serialization.Contextual
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

enum class EnumKind1(val value: String) {
    @SerialName("\$CreatedBy")
    CreatedBy("\$CreatedBy"),

    @SerialName("header")
    Header("header"),

    @SerialName("name")
    Name("name")
}


interface DtoMessagePayload {
    var isForwarded: Boolean?
    var mentionMap: Map<String, @Contextual ContactId>?
    var messageType: EnumMessageType
}

interface DtoMessagePayloadText : DtoMessagePayload {
    var isUpdated: Boolean?
    var text: String
}


interface DtoMessagePayloadImage : DtoMessagePayloadText {
    var fileSize: Long?
    var height: Long?
    var mediaIdBlurImage: @Contextual MediaIdImage
    var mediaIdImage: @Contextual MediaIdImage
    var primaryColor: String
    var width: Long?
}


interface SigMessageBase {
    var creationTime: String
    var isCallerSender: Boolean?
    var messageId: @Contextual Types.MessageId
    var messageOffset: Int?
    var payload: DtoMessagePayload
}

interface SigMessage : SigMessageBase {
    var receiptStatus: EnumReceiptStatus?
    var version: String?
}

// Serializable sealed hierarchy for polymorphic deserialization
@Serializable
sealed class DtoMessagePayloadSer : DtoMessagePayload

@Serializable
@SerialName("text")
data class DtoMessagePayloadTextSer(
    override var isForwarded: Boolean? = null,
    override var mentionMap: Map<String, @Contextual ContactId>? = null,
    override var messageType: EnumMessageType = EnumMessageType.text,
    override var isUpdated: Boolean? = null,
    override var text: String,
) : DtoMessagePayloadSer(), DtoMessagePayloadText

@Serializable
@SerialName("image")
data class DtoMessagePayloadImageSer(
    override var isForwarded: Boolean? = null,
    override var mentionMap: Map<String, @Contextual ContactId>? = null,
    override var messageType: EnumMessageType = EnumMessageType.image,
    override var isUpdated: Boolean? = null,
    override var text: String = "",
    override var fileSize: Long? = null,
    override var height: Long? = null,
    override var mediaIdBlurImage: @Contextual MediaIdImage,
    override var mediaIdImage: @Contextual MediaIdImage,
    override var primaryColor: String,
    override var width: Long? = null,
) : DtoMessagePayloadSer(), DtoMessagePayloadImage

// Add more payload types as needed (audio, video, document, etc.)
@Serializable
@SerialName("audio")
data class DtoMessagePayloadAudioSer(
    override var isForwarded: Boolean? = null,
    override var mentionMap: Map<String, @Contextual ContactId>? = null,
    override var messageType: EnumMessageType = EnumMessageType.audio,
    override var isUpdated: Boolean? = null,
    override var text: String = "",
) : DtoMessagePayloadSer(), DtoMessagePayloadText

@Serializable
data class SigMessageSer(
    override var receiptStatus: EnumReceiptStatus? = null,
    override var version: String? = null,
    override var creationTime: String,
    override var isCallerSender: Boolean? = null,
    @Contextual override var messageId: Types.MessageId,
    override var messageOffset: Int? = null,
    @Serializable(with = DtoMessagePayloadSerializer::class)
    override var payload: DtoMessagePayload
) : SigMessage


object DtoMessagePayloadSerializer : JsonContentPolymorphicSerializer<DtoMessagePayload>(
    DtoMessagePayload::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DtoMessagePayload> {
        val messageType = element.jsonObject["messageType"]?.jsonPrimitive?.content
        return when (messageType) {
            "text", EnumMessageType.text.value -> DtoMessagePayloadTextSer.serializer()
            "image", EnumMessageType.image.value -> DtoMessagePayloadImageSer.serializer()
            "audio", EnumMessageType.audio.value -> DtoMessagePayloadAudioSer.serializer()
            else -> DtoMessagePayloadSer.serializer() // Default fallback
        }
    }
}
