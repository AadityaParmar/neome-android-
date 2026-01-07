package com.neome.core.common.serializer.sysId

import com.neome.api.meta.base.SysId
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
