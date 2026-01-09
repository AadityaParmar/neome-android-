package com.neome.core.common.serializer


// Symbol serializer (AnyValue-based type)
//object SymbolSer : KSerializer<Symbol> {
//    override val descriptor: SerialDescriptor =
//        PrimitiveSerialDescriptor("Symbol", PrimitiveKind.STRING)
//
//    override fun serialize(encoder: Encoder, value: Symbol) {
//        encoder.encodeString(value.toString())
//    }
//
//    override fun deserialize(decoder: Decoder): Symbol {
//        val string = decoder.decodeString()
//        return Symbol().apply { value = string }
//    }
//}
//
