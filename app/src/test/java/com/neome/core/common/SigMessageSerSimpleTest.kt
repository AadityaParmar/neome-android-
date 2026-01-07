package com.neome.core.common

import com.neome.core.common.serializer.api.DtoMessagePayloadText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Test class for JSON to Kotlin class deserialization
 * Tests DtoMessagePayloadText and DtoMessagePayloadImage with realistic dummy JSON
 */
class SigMessageSerSimpleTest {

    private lateinit var json: Json

    @Before
    fun setup() {
        json = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true

            // Configure serializers module for contextual types
            serializersModule = SerializersModule {
                // Register custom serializers for contextual types


                // Note: Payload polymorphism is handled by DtoMessagePayloadSerializer
                // which inspects the messageType field
            }
        }
    }

    // ==========================================
    // TEXT MESSAGE DESERIALIZATION TESTS
    // ==========================================

    @Test
    fun `deserialize simple text message`() {
        // Given - Minimal text message JSON
        val jsonString = """
        {
          "creationTime": "2024-01-06T10:30:00Z",
          "messageId": "m-test",
          "payload": {
              "messageType": "text",
              "dtoText": {
                "value": ["Please enter", "a unique username"]
              },
            "text": "Hello, how are you?",
          "enumTest2": "${'$'}CreatedBy",
          "enumTest1": "name"
          }
        }
        """.trimIndent()

        // When
        val message = json.decodeFromString<SigMessageData>(jsonString)
        val messageStr = json.encodeToString(message)

        // Then
        println("\n=== Deserialized Simple Text Message ===")
        println("Message ID: ${message.messageId}")
        println("Creation Time: ${message.creationTime}")
        println("messageOffset: ${message.messageOffset}")
        println("Payload messageType: ${message.payload.messageType}")
        println("Payload dtoText: ${message.payload.dtoText}")
        println("messageStr: ${messageStr}")
        println("Payload enumTest2: ${EnumKind.Name.value}")
        println("Payload enumTest2: ${EnumKind.Name.name}")
        println("Payload text: ${(message.payload as DtoMessagePayloadText).text}")
        println("Payload Type: ${message.payload::class.simpleName}")
        println("=========================================\n")

        Assert.assertNotNull(message)
        Assert.assertEquals("2024-01-06T10:30:00Z", message.creationTime)
        Assert.assertTrue(message.payload is DtoMessagePayloadTextData)

        val textPayload = message.payload as DtoMessagePayloadTextData
        Assert.assertEquals("Hello, how are you?", textPayload.text)
        Assert.assertEquals(
            com.neome.api.home.base.Types.EnumMessageType.text,
            textPayload.messageType
        )
        Assert.assertNull(textPayload.isForwarded)
        Assert.assertNull(textPayload.isUpdated)

    }

    @Test
    fun `deserialize full text message with all fields`() {
        // Given - Complete text message JSON with all optional fields
        val jsonString = """
        {
          "receiptStatus": "blueTick",
          "version": "1.0.0",
          "creationTime": "2024-01-06T11:00:00Z",
          "isCallerSender": true,
          "messageId": "m-test2",
          "messageOffset": 5,
          "payload": {
            "isForwarded": true,
            "mentionMap": {
              "@john": "eu-001",
              "@jane": "eu-002"
            },
            "messageType": "text",
            "isUpdated": false,
            "text": "Hey @john and @jane, check this out!"
          }
        }
        """.trimIndent()

        // When
        val message = json.decodeFromString<SigMessageData>(jsonString)

        // Then
        println("\n=== Deserialized Full Text Message ===")
        println("Message ID: ${message.messageId}")
        println("Receipt Status: ${message.receiptStatus}")
        println("Version: ${message.version}")
        println("MentionMap: ${(message.payload as DtoMessagePayloadText).mentionMap}")
        println("Is Caller Sender: ${message.isCallerSender}")
        println("Message Offset: ${message.messageOffset}")
        println("========================================\n")

        Assert.assertNotNull(message.messageId) // MessageId deserialized successfully
        Assert.assertEquals(
            com.neome.api.home.base.Types.EnumReceiptStatus.blueTick,
            message.receiptStatus
        )
        Assert.assertEquals("1.0.0", message.version)
        Assert.assertEquals(true, message.isCallerSender)
        Assert.assertEquals(5, message.messageOffset)

        Assert.assertTrue(message.payload is DtoMessagePayloadTextData)
        val textPayload = message.payload as DtoMessagePayloadTextData
        Assert.assertEquals("Hey @john and @jane, check this out!", textPayload.text)
        Assert.assertEquals(true, textPayload.isForwarded)
        Assert.assertEquals(false, textPayload.isUpdated)
        Assert.assertNotNull(textPayload.mentionMap)
        Assert.assertEquals(2, textPayload.mentionMap?.size)
    }

    @Test
    fun `deserialize text message with unknown fields`() {
        // Given - JSON with extra unknown fields that should be ignored
        val jsonString = """
        {
          "creationTime": "2024-01-06T12:00:00Z",
          "messageId": "m-test3",
          "unknownField1": "should be ignored",
          "extraData": 12345,
          "payload": {
            "messageType": "text",
            "text": "Message with unknown fields",
            "extraPayloadField": "also ignored"
          }
        }
        """.trimIndent()

        // When
        val message = json.decodeFromString<SigMessageData>(jsonString)

        // Then
        Assert.assertNotNull(message)
        Assert.assertTrue(message.payload is DtoMessagePayloadTextData)
        val textPayload = message.payload as DtoMessagePayloadTextData
        Assert.assertEquals("Message with unknown fields", textPayload.text)
    }

    // ==========================================
    // IMAGE MESSAGE DESERIALIZATION TESTS
    // ==========================================

    @Test
    fun `deserialize simple image message`() {
        // Given - Minimal image message JSON
        val jsonString = """
        {
          "creationTime": "2024-01-06T13:00:00Z",
          "messageId": "m-test4",
          "payload": {
            "messageType": "image",
            "text": "Beautiful sunset",
            "mediaIdImage": "mi-xyz123",
            "mediaIdBlurImage": "mi-blurxyz123",
            "primaryColor": "#FF6B35"
          }
        }
        """.trimIndent()

        // When
        val message = json.decodeFromString<SigMessageData>(jsonString)

        // Then
        println("\n=== Deserialized Simple Image Message ===")
        println("Message ID: ${message.messageId}")
        println("Payload Type: ${message.payload::class.simpleName}")
        println("==========================================\n")
        Assert.assertNotNull(message)
        Assert.assertTrue(message.payload is DtoMessagePayloadImageData)

        val imagePayload = message.payload as DtoMessagePayloadImageData
        Assert.assertEquals("Beautiful sunset", imagePayload.text)
        Assert.assertEquals(
            com.neome.api.home.base.Types.EnumMessageType.image,
            imagePayload.messageType
        )
        Assert.assertEquals("#FF6B35", imagePayload.primaryColor)
        Assert.assertNull(imagePayload.width)
        Assert.assertNull(imagePayload.height)
        Assert.assertNull(imagePayload.fileSize)
    }

    @Test
    fun `deserialize full image message with all fields`() {
        // Given - Complete image message JSON with all optional fields
        val jsonString = """
        {
          "receiptStatus": "doubleTick",
          "version": "2.1.0",
          "creationTime": "2024-01-06T14:30:00Z",
          "isCallerSender": false,
          "messageId": "m-test5",
          "messageOffset": 12,
          "payload": {
            "isForwarded": false,
            "mentionMap": null,
            "messageType": "image",
            "isUpdated": true,
            "text": "Check out this amazing photo! 📸",
            "fileSize": 2457600,
            "height": 1920,
            "mediaIdImage": "mi-abc456",
            "mediaIdBlurImage": "mi-blurabc456",
            "primaryColor": "#4A90E2",
            "width": 1080
          }
        }
        """.trimIndent()

        // When
        val message = json.decodeFromString<SigMessageData>(jsonString)

        // Then
        println("\n=== Deserialized Full Image Message ===")
        println("Message ID: ${message.messageId}")
        println("Receipt Status: ${message.receiptStatus}")
        println("Is Caller Sender: ${message.isCallerSender}")
        println("Image Width: ${(message.payload as DtoMessagePayloadImageData).width}")
        println("Image Height: ${(message.payload as DtoMessagePayloadImageData).height}")
        println("File Size: ${(message.payload as DtoMessagePayloadImageData).fileSize} bytes")
        println("========================================\n")

        Assert.assertEquals(
            com.neome.api.home.base.Types.EnumReceiptStatus.doubleTick,
            message.receiptStatus
        )
        Assert.assertEquals("2.1.0", message.version)
        Assert.assertEquals(false, message.isCallerSender)
        Assert.assertEquals(12, message.messageOffset)

        Assert.assertTrue(message.payload is DtoMessagePayloadImageData)
        val imagePayload = message.payload as DtoMessagePayloadImageData
        Assert.assertEquals("Check out this amazing photo! 📸", imagePayload.text)
        Assert.assertEquals(false, imagePayload.isForwarded)
        Assert.assertEquals(true, imagePayload.isUpdated)
        Assert.assertEquals(1080L, imagePayload.width)
        Assert.assertEquals(1920L, imagePayload.height)
        Assert.assertEquals(2457600L, imagePayload.fileSize)
        Assert.assertEquals("#4A90E2", imagePayload.primaryColor)
    }

    @Test
    fun `deserialize image message with partial dimensions`() {
        // Given - Image message with only some dimension fields
        val jsonString = """
        {
          "creationTime": "2024-01-06T15:00:00Z",
          "messageId": "m-test6",
          "payload": {
            "messageType": "image",
            "text": "Portrait photo",
            "width": 1080,
            "mediaIdImage": "mi-portrait",
            "mediaIdBlurImage": "mi-blurportrait",
            "primaryColor": "#8E44AD"
          }
        }
        """.trimIndent()

        // When
        val message = json.decodeFromString<SigMessageData>(jsonString)

        // Then
        Assert.assertTrue(message.payload is DtoMessagePayloadImageData)
        val imagePayload = message.payload as DtoMessagePayloadImageData
        Assert.assertEquals(1080L, imagePayload.width)
        Assert.assertNull(imagePayload.height)
        Assert.assertNull(imagePayload.fileSize)
    }

    // ==========================================
    // POLYMORPHIC TYPE DISCRIMINATION TESTS
    // ==========================================

    @Test
    fun `deserialize multiple messages and verify correct types`() {
        // Given - JSON array with different message types
        val textJson = """
        {
          "creationTime": "2024-01-06T16:00:00Z",
          "messageId": "m-test7",
          "payload": {
            "messageType": "text",
            "text": "This is a text message"
          }
        }
        """.trimIndent()

        val imageJson = """
        {
          "creationTime": "2024-01-06T16:05:00Z",
          "messageId": "m-test8",
          "payload": {
            "messageType": "image",
            "text": "This is an image",
            "mediaIdImage": "mi-multi",
            "mediaIdBlurImage": "mi-blurmulti",
            "primaryColor": "#27AE60"
          }
        }
        """.trimIndent()

        // When
        val textMessage = json.decodeFromString<SigMessageData>(textJson)
        val imageMessage = json.decodeFromString<SigMessageData>(imageJson)

        // Then
        println("\n=== Polymorphic Type Discrimination ===")
        println("Text message type: ${textMessage.payload::class.simpleName}")
        println("Image message type: ${imageMessage.payload::class.simpleName}")
        println("========================================\n")

        Assert.assertTrue(textMessage.payload is DtoMessagePayloadTextData)
        Assert.assertTrue(imageMessage.payload is DtoMessagePayloadImageData)

        // Verify we can access type-specific fields
        val textPayload = textMessage.payload as DtoMessagePayloadTextData
        Assert.assertEquals("This is a text message", textPayload.text)

        val imagePayload = imageMessage.payload as DtoMessagePayloadImageData
        Assert.assertEquals("#27AE60", imagePayload.primaryColor)
    }

    @Test
    fun `deserialize messages with null optional fields`() {
        // Given - Message with explicit null values
        val jsonString = """
        {
          "receiptStatus": null,
          "version": null,
          "creationTime": "2024-01-06T17:00:00Z",
          "isCallerSender": null,
          "messageId": "m-test9",
          "messageOffset": null,
          "payload": {
            "isForwarded": null,
            "mentionMap": null,
            "messageType": "text",
            "isUpdated": null,
            "text": "Message with nulls"
          }
        }
        """.trimIndent()

        // When
        val message = json.decodeFromString<SigMessageData>(jsonString)

        // Then
        Assert.assertNull(message.receiptStatus)
        Assert.assertNull(message.version)
        Assert.assertNull(message.isCallerSender)
        Assert.assertNull(message.messageOffset)

        val textPayload = message.payload as DtoMessagePayloadTextData
        Assert.assertNull(textPayload.isForwarded)
        Assert.assertNull(textPayload.mentionMap)
        Assert.assertNull(textPayload.isUpdated)
        Assert.assertEquals("Message with nulls", textPayload.text)
    }

    // ==========================================
    // WHEN EXPRESSION PATTERN MATCHING TEST
    // ==========================================

    @Test
    fun `pattern match on payload types`() {
        // Given - Different message types
        val messages = listOf(
            """{"creationTime": "2024-01-06T18:00:00Z", "messageId": "m-test10", "payload": {"messageType": "text", "text": "Text"}}""",
            """{"creationTime": "2024-01-06T18:01:00Z", "messageId": "m-test11", "payload": {"messageType": "image", "text": "Image", "mediaIdImage": "mi-i1", "mediaIdBlurImage": "mi-b1", "primaryColor": "#FFF"}}"""
        )

        // When - Deserialize and pattern match
        val results = messages.map { jsonString ->
            val message = json.decodeFromString<SigMessageData>(jsonString)
            when (val payload = message.payload) {
                is DtoMessagePayloadTextData -> "Text: ${payload.text}"
                is DtoMessagePayloadImageData -> "Image: ${payload.primaryColor}"
                is DtoMessagePayloadAudioData -> "Audio message"
                else -> "Unknown type: ${payload::class.simpleName}"
            }
        }

        // Then
        println("\n=== Pattern Matching Results ===")
        results.forEach { println(it) }
        println("=================================\n")

        Assert.assertEquals("Text: Text", results[0])
        Assert.assertEquals("Image: #FFF", results[1])
    }
}
