# Kotlinx.Serialization Setup for Message Payload

## Summary

I've successfully created a polymorphic serialization structure using kotlinx.serialization for your message payload system. The `messageType` field acts as the discriminator to determine which payload type to deserialize.

## Structure Created

### Sealed Class Hierarchy

```kotlin
@Serializable
sealed class DtoMessagePayloadSer : DtoMessagePayload {

    @Serializable
    @SerialName("text")
    data class text(...) : DtoMessagePayloadSer(), DtoMessagePayloadText

    @Serializable
    @SerialName("image")
    data class image(...) : DtoMessagePayloadSer(), DtoMessagePayloadImage

    @Serializable
    @SerialName("audio")
    data class audio(...) : DtoMessagePayloadSer(), DtoMessagePayloadText
}
```

### Key Features

1. **Sealed Class**: `DtoMessagePayloadSer` extends `DtoMessagePayload` interface
2. **Nested Data Classes**: Each message type is a nested data class with lowercase names (text, image, audio)
3. **@SerialName**: Maps to the JSON `messageType` field value
4. **Interface Implementation**: Each nested class implements both `DtoMessagePayloadSer` and its specific interface

## Required Configuration

### 1. Configure Json Instance with Polymorphic Serialization

You need to set up a `Json` instance with the `classDiscriminator` and `serializersModule`:

```kotlin
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
    classDiscriminator = "messageType"

    serializersModule = SerializersModule {
        polymorphic(DtoMessagePayloadSer::class) {
            subclass(DtoMessagePayloadSer.text::class)
            subclass(DtoMessagePayloadSer.image::class)
            subclass(DtoMessagePayloadSer.audio::class)
        }
    }
}
```

### 2. Create Custom Serializers for Types

The following types are marked as `@Contextual` and need custom serializers:

- `Types.MessageId`
- `Types.ContactId`
- `Types.MediaIdImage`

You have two options:

#### Option A: Create KSerializer implementations

```kotlin
object MessageIdSerializer : KSerializer<Types.MessageId> {
    override val descriptor = PrimitiveSerialDescriptor("MessageId", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Types.MessageId) {
        encoder.encodeString(value.toString()) // Implement your serialization logic
    }

    override fun deserialize(decoder: Decoder): Types.MessageId {
        val string = decoder.decodeString()
        // Implement your deserialization logic
        return // create MessageId from string
    }
}
```

Then register them in the SerializersModule:

```kotlin
serializersModule = SerializersModule {
    contextual(Types.MessageId::class, MessageIdSerializer)
    contextual(Types.ContactId::class, ContactIdSerializer)
    contextual(Types.MediaIdImage::class, MediaIdImageSerializer)

    polymorphic(DtoMessagePayloadSer::class) {
        subclass(DtoMessagePayloadSer.text::class)
        subclass(DtoMessagePayloadSer.image::class)
        subclass(DtoMessagePayloadSer.audio::class)
    }
}
```

#### Option B: Make these types @Serializable

If these classes can be annotated with `@Serializable`, that's the simplest approach:

```kotlin
@Serializable
open class MessageId : SysId() { ... }
```

## Usage Example

### Serialization (Kotlin to JSON)

```kotlin
val message = SigMessageSer(
    creationTime = "2024-01-06T10:00:00Z",
    messageId = MessageId(...), // Proper MessageId object
    payload = DtoMessagePayloadSer.text(
        messageType = EnumMessageType.text,
        text = "Hello World"
    )
)

val jsonString = json.encodeToString(message)
```

### Deserialization (JSON to Kotlin)

```kotlin
val jsonString = """
{
    "creationTime": "2024-01-06T10:00:00Z",
    "messageId": "msg_123",
    "payload": {
        "messageType": "text",
        "text": "Hello World"
    }
}
"""

val message = json.decodeFromString<SigMessageSer>(jsonString)

// Pattern matching on payload type
when (val payload = message.payload) {
    is DtoMessagePayloadSer.text -> println("Text: ${payload.text}")
    is DtoMessagePayloadSer.image -> println("Image: ${payload.mediaIdImage}")
    is DtoMessagePayloadSer.audio -> println("Audio message")
}
```

## Adding More Message Types

To add new message types (video, document, etc.):

1. Add the nested data class to `DtoMessagePayloadSer`:

```kotlin
@Serializable
@SerialName("video")
data class video(
    override var isForwarded: Boolean? = null,
    override var mentionMap: Map<String, @Contextual ContactId>? = null,
    override var messageType: EnumMessageType = EnumMessageType.video,
    override var isUpdated: Boolean? = null,
    override var text: String = "",
    // Video-specific fields
    var duration: Long? = null,
    var mediaIdVideo: @Contextual MediaIdVideo
) : DtoMessagePayloadSer(), DtoMessagePayloadVideo
```

2. Register it in the SerializersModule:

```kotlin
polymorphic(DtoMessagePayloadSer::class) {
    subclass(DtoMessagePayloadSer.text::class)
    subclass(DtoMessagePayloadSer.image::class)
    subclass(DtoMessagePayloadSer.audio::class)
    subclass(DtoMessagePayloadSer.video::class) // Add here
}
```

## Changes Made

### In SerializationDtos.kt
- Created `DtoMessagePayloadSer` sealed class with nested data classes
- Added `@Serializable` and `@SerialName` annotations
- Marked custom types with `@Contextual`
- Changed `Number` to `Long` for numeric fields
- Changed payload type in `SigMessageSer` to `DtoMessagePayload` (to match interface)

### In Types.kt
- Fixed `MessageId` from `interface` to `open class` (was causing compilation error)

## Test Fixes Needed

The existing tests need updates:

1. **Create proper type instances** instead of using Strings:
   ```kotlin
   // Instead of:
   messageId = "msg_123"

   // Use:
   messageId = MessageId(...) // Create proper object
   ```

2. **Add `argCtx` field** if needed (currently referenced in test but not in model)

3. **Make `when` expressions exhaustive** by adding `audio` case or `else` branch

## Next Steps

1. Implement custom serializers for `MessageId`, `ContactId`, and `MediaIdImage`
2. Configure the `Json` instance with the SerializersModule
3. Update tests to use proper type instances
4. Add remaining message types (video, document, etc.) as needed
