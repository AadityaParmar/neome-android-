package com.neome.core.common.serializer

import com.neome.api.meta.base.Symbol
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


// Symbol serializer (AnyValue-based type)
object SymbolSer : KSerializer<Symbol> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Symbol", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Symbol) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): Symbol {
        val string = decoder.decodeString()
        return Symbol().apply { value = string }
    }
}


