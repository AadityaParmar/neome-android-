package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.Types.EnumDefnTime
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.api.meta.base.dto.StudioDtoArgValueContext
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextCallerData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextCallerSettingData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextEntData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueDerivedData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueFieldData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueVariableData
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object ArgValueResolver {

    // region --- TypeCustomValueMap hierarchy ---

    @Serializable(with = TypeCustomValueMapSerializer::class)
    sealed interface TypeCustomValueMap {
        val id: String
        val kind: String
        val name: String
    }

    @Serializable
    data class TypeCustomValueDate(
        override val id: String,
        override val kind: String,
        override val name: String,
        val value: EnumDefnDate? = null,
        val customDate: String? = null
    ) : TypeCustomValueMap

    @Serializable
    data class TypeCustomValueTime(
        override val id: String,
        override val kind: String,
        override val name: String,
        val customValue: String? = null,
        val value: EnumDefnTime? = null
    ) : TypeCustomValueMap

    @Serializable
    data class TypeCustomValueDateTime(
        override val id: String,
        override val kind: String,
        override val name: String,
        val value: EnumDefnDate? = null,
        val customDate: String? = null,
        val customTime: String? = null
    ) : TypeCustomValueMap

    @Serializable
    data class TypeCustomValueSeq(
        override val id: String,
        override val kind: String,
        override val name: String
    ) : TypeCustomValueMap

    // endregion

    // region --- TypeCustomValueMapSerializer ---

    object TypeCustomValueMapSerializer :
        JsonContentPolymorphicSerializer<TypeCustomValueMap>(TypeCustomValueMap::class) {

        override fun selectDeserializer(
            element: JsonElement
        ): DeserializationStrategy<TypeCustomValueMap> {
            val kind = element.jsonObject["kind"]?.jsonPrimitive?.content
            return when (kind) {
                "date" -> TypeCustomValueDate.serializer()
                "time" -> TypeCustomValueTime.serializer()
                "dateTime" -> TypeCustomValueDateTime.serializer()
                "sequence" -> TypeCustomValueSeq.serializer()
                else -> TypeCustomValueSeq.serializer()
            }
        }
    }

    // endregion

    // region --- StudioDtoArgValueContextSerializer ---

    object StudioDtoArgValueContextSerializer :
        JsonContentPolymorphicSerializer<StudioDtoArgValueContext>(
            StudioDtoArgValueContext::class
        ) {

        override fun selectDeserializer(
            element: JsonElement
        ): DeserializationStrategy<StudioDtoArgValueContext> {
            val kind = element.jsonObject["kind"]?.jsonPrimitive?.content
            return when (kind) {
                EnumDefnArgBinderContext.caller.value ->
                    StudioDtoArgValueContextCallerData.serializer()

                EnumDefnArgBinderContext.callerSetting.value ->
                    StudioDtoArgValueContextCallerSettingData.serializer()

                EnumDefnArgBinderContext.ent.value ->
                    StudioDtoArgValueContextEntData.serializer()

                else -> StudioDtoArgValueContextData.serializer()
            }
        }
    }

    // endregion

    // region --- StudioDtoArgValueForClient ---

    @Serializable(with = StudioDtoArgValueForClientSerializer::class)
    data class StudioDtoArgValueForClient(
        val kind: EnumDefnArgBinder,
        val argValue: StudioDtoArgValue,
        val customValueMap: TypeCustomValueMap? = null
    )

    // endregion

    // region --- StudioDtoArgValueForClientSerializer ---

    object StudioDtoArgValueForClientSerializer : KSerializer<StudioDtoArgValueForClient> {

        override val descriptor: SerialDescriptor =
            buildClassSerialDescriptor("StudioDtoArgValueForClient") {
                element("kind", PrimitiveSerialDescriptor("EnumDefnArgBinder", PrimitiveKind.STRING))
                element("argValue", buildClassSerialDescriptor("StudioDtoArgValue"))
                element(
                    "customValueMap",
                    TypeCustomValueMapSerializer.descriptor,
                    isOptional = true
                )
            }

        override fun deserialize(decoder: Decoder): StudioDtoArgValueForClient {
            val jsonDecoder = decoder as? JsonDecoder
                ?: throw SerializationException(
                    "StudioDtoArgValueForClientSerializer requires JsonDecoder"
                )
            val json = jsonDecoder.json
            val element = jsonDecoder.decodeJsonElement().jsonObject

            val kindStr = element["kind"]?.jsonPrimitive?.content
                ?: throw SerializationException(
                    "Missing 'kind' field in StudioDtoArgValueForClient"
                )

            val kind = EnumDefnArgBinder.entries.firstOrNull { it.value == kindStr }
                ?: throw SerializationException(
                    "Unknown EnumDefnArgBinder: $kindStr"
                )

            val argValueElement = element["argValue"]
                ?: throw SerializationException(
                    "Missing 'argValue' field in StudioDtoArgValueForClient"
                )

            val argValue: StudioDtoArgValue = when (kind) {
                EnumDefnArgBinder.Context -> json.decodeFromJsonElement(
                    StudioDtoArgValueContextSerializer, argValueElement
                )

                EnumDefnArgBinder.derived -> json.decodeFromJsonElement(
                    StudioDtoArgValueDerivedData.serializer(), argValueElement
                )

                EnumDefnArgBinder.variable -> json.decodeFromJsonElement(
                    StudioDtoArgValueVariableData.serializer(), argValueElement
                )

                EnumDefnArgBinder.field -> json.decodeFromJsonElement(
                    StudioDtoArgValueFieldData.serializer(), argValueElement
                )

                else -> json.decodeFromJsonElement(
                    StudioDtoArgValueContextData.serializer(), argValueElement
                )
            }

            val customValueMap = element["customValueMap"]?.let {
                json.decodeFromJsonElement(TypeCustomValueMapSerializer, it)
            }

            return StudioDtoArgValueForClient(kind, argValue, customValueMap)
        }

        override fun serialize(encoder: Encoder, value: StudioDtoArgValueForClient) {
            throw SerializationException(
                "Serialization not supported for StudioDtoArgValueForClient"
            )
        }
    }

    // endregion

    fun resolveArgForFieldVal(
        defnForm: DefnForm,
        formValue: FormValueData?,
        argValue: DefnDtoText,
    ): DefnDtoText {
        return argValue
    }
}
