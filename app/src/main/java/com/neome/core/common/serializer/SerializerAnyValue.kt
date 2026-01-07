package com.neome.core.common.serializer

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.dto.DefnDtoText
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ArraySerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
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

// DefnDtoText serializer
object DefnDtoTextSer : KSerializer<DefnDtoText> {
    private val arraySerializer = ArraySerializer(String.serializer())

    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("DefnDtoText") {
            element("value", arraySerializer.descriptor, isOptional = true)
        }

    override fun serialize(encoder: Encoder, value: DefnDtoText) {
        val compositeEncoder = encoder.beginStructure(descriptor)
        compositeEncoder.encodeNullableSerializableElement(
            descriptor,
            0,
            arraySerializer,
            value.value
        )
        compositeEncoder.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): DefnDtoText {
        val compositeDecoder = decoder.beginStructure(descriptor)
        var value: Array<String>? = null

        while (true) {
            when (val index = compositeDecoder.decodeElementIndex(descriptor)) {
                0 -> value = compositeDecoder.decodeNullableSerializableElement(
                    descriptor,
                    0,
                    arraySerializer
                )

                CompositeDecoder.DECODE_DONE -> break
                else -> throw kotlinx.serialization.SerializationException("Unknown index $index")
            }
        }

        compositeDecoder.endStructure(descriptor)
        return DefnDtoText().apply {
            this.value = value
        }
    }
}

