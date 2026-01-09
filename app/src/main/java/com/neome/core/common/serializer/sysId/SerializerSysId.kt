package com.neome.core.common.serializer.sysId

import com.neome.api.meta.base.AnyValue
import com.neome.api.meta.base.SysId
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject

open class SysIdSerializer<T : SysId>(descriptor: String) : KSerializer<T> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(descriptor, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): T {
        val string = decoder.decodeString()
        // Use SysId.create() to properly create and initialize the MessageId
        return SysId.create(string)
            ?: throw IllegalArgumentException("Failed to create SysId from: $string")
    }
}


open class AnyValueSerializer<T : AnyValue>(
    descriptor: String,
    private val cls: Class<T>
) : KSerializer<T> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(descriptor, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): T {
        val string = decoder.decodeString()
        return AnyValue.create(string, cls)
            ?: throw IllegalArgumentException("Failed to create AnyValue from: $string")
    }
}


@OptIn(InternalSerializationApi::class)
object ObjectSer : KSerializer<Any> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Object", PolymorphicKind.SEALED) {
            element("value", JsonElement.serializer().descriptor)
        }

    override fun serialize(encoder: Encoder, value: Any) {
        val jsonElement = when (value) {
            is JsonElement -> value
            is String -> JsonPrimitive(value)
            is Number -> JsonPrimitive(value)
            is Boolean -> JsonPrimitive(value)
            is Map<*, *> -> buildJsonObject {
                value.forEach { (k, v) ->
                    if (k != null && v != null) {
                        put(k.toString(), serializeValue(v))
                    }
                }
            }

            is Iterable<*> -> buildJsonArray {
                value.forEach { v ->
                    if (v != null) add(serializeValue(v))
                }
            }

            else -> JsonPrimitive(value.toString())
        }
        encoder.encodeSerializableValue(JsonElement.serializer(), jsonElement)
    }

    override fun deserialize(decoder: Decoder): Any {
        return decoder.decodeSerializableValue(JsonElement.serializer())
    }

    private fun serializeValue(value: Any): JsonElement = when (value) {
        is String -> JsonPrimitive(value)
        is Number -> JsonPrimitive(value)
        is Boolean -> JsonPrimitive(value)
        is JsonElement -> value
        else -> JsonPrimitive(value.toString())
    }
}

// For Any? type (nullable)
@OptIn(InternalSerializationApi::class)
object AnySer : KSerializer<Any?> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Any", PolymorphicKind.SEALED) {
            element("value", JsonElement.serializer().descriptor)
        }

    override fun serialize(encoder: Encoder, value: Any?) {
        if (value == null) {
            encoder.encodeNull()
            return
        }

        val jsonElement = when (value) {
            is JsonElement -> value
            is String -> JsonPrimitive(value)
            is Number -> JsonPrimitive(value)
            is Boolean -> JsonPrimitive(value)
            is Map<*, *> -> buildJsonObject {
                value.forEach { (k, v) ->
                    if (k != null && v != null) {
                        put(k.toString(), serializeValue(v))
                    }
                }
            }

            is Iterable<*> -> buildJsonArray {
                value.forEach { v ->
                    if (v != null) add(serializeValue(v))
                }
            }

            else -> JsonPrimitive(value.toString())
        }
        encoder.encodeSerializableValue(JsonElement.serializer(), jsonElement)
    }

    override fun deserialize(decoder: Decoder): Any? {
        return if (decoder.decodeNotNullMark()) {
            decoder.decodeSerializableValue(JsonElement.serializer())
        } else {
            decoder.decodeNull()
        }
    }

    private fun serializeValue(value: Any): JsonElement = when (value) {
        is String -> JsonPrimitive(value)
        is Number -> JsonPrimitive(value)
        is Boolean -> JsonPrimitive(value)
        is JsonElement -> value
        else -> JsonPrimitive(value.toString())
    }
}
