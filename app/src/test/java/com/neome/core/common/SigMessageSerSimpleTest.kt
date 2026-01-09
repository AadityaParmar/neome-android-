package com.neome.core.common

import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.main.sig.SigMessageData
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
        // Given - Real text message JSON from production
        val jsonString = """
        {
            "name": "Test",
            "jsonObject": {
                "text": "I will join office in second half today",
                "messageType": "text"
            },
            "version": "994ibA2V6DqNrH5iGnxuli0DE",
            "messageId": "m-Siosyh8WHnxLQfPskp6W9whd0",
            "messageOffset": 5539,
            "senderId": "eu-KvvdpvCE1ypF4LXmMOadMkpyh",
            "payload": {
                "text": "I will join office in second half today",
                "messageType": "text"
            },
            "creationTime": "2026-01-07T03:58:16.178Z"
        }
        """.trimIndent()

        // When
        val message =
            json.decodeFromString<SigMessageData>(jsonString)
        val messageStr = json.encodeToString(message)

        // Then
        println("\n=== Deserialized Simple Text Message ===")
        println("Message ID: ${message.messageId}")
//        println("Message Name: ${message.name}")
//        println("Message jsonObject: ${message.jsonObject}")
        println("Creation Time: ${message.creationTime}")
        println("messageOffset: ${message.messageOffset}")
        println("Payload messageType: ${message.payload.messageType}")
        println("messageStr: ${messageStr}")
        println("Payload text: ${(message.payload as DtoMessagePayloadText).text}")
        println("Payload Type: ${message.payload::class.simpleName}")
        println("=========================================\n")

        Assert.assertNotNull(message)
        Assert.assertEquals(
            SysId.create<Types.MessageId>("m-Siosyh8WHnxLQfPskp6W9whd0"),
            message.messageId
        )
        Assert.assertEquals("2026-01-07T03:58:16.178Z", message.creationTime)
        Assert.assertEquals(5539L, message.messageOffset)
        Assert.assertEquals(
            SysId.create<Types.EntUserId>("eu-KvvdpvCE1ypF4LXmMOadMkpyh"),
            message.senderId
        )
        Assert.assertTrue(message.payload is com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData)

        val textPayload =
            message.payload as com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData
        Assert.assertEquals("I will join office in second half today", textPayload.text)
        Assert.assertEquals(
            com.neome.api.home.base.Types.EnumMessageType.text,
            textPayload.messageType
        )
        Assert.assertNull(textPayload.isForwarded)
        Assert.assertNull(textPayload.isUpdated)
        Assert.assertNull(textPayload.mentionMap)
    }

    @Test
    fun `deserialize text message with mentions`() {
        // Given - Real text message with mention map from production
        val jsonString = """
        {
            "version": "gExZQwJx0PFVPHWPxUg4cXBV5",
            "messageId": "m-lPdjmHvogvnmq0qOv0dkq1uAJ",
            "messageOffset": 5542,
            "senderId": "eu-JWPE5dBLnZihfOYhn0Bzx3K8m",
            "payload": {
                "text": "Happy Birthday @Brijesh Dobariya 🎂🎉",
                "messageType": "text",
                "mentionMap": {
                    "@Brijesh Dobariya": "eu-XBEkfLMw9KUbd6GPtH5G2RkTj"
                }
            },
            "creationTime": "2026-01-07T04:22:26.369Z"
        }
        """.trimIndent()

        // When
        val message =
            json.decodeFromString<SigMessageData>(jsonString)

        // Then
        println("\n=== Deserialized Text Message with Mentions ===")
        println("Message ID: ${message.messageId}")
        println("Version: ${message.version}")
        println("MentionMap: ${(message.payload as DtoMessagePayloadText).mentionMap}")
        println("Message Offset: ${message.messageOffset}")
        println("===============================================\n")

        Assert.assertNotNull(message.messageId)
        Assert.assertEquals(
            SysId.create<Types.MessageId>("m-lPdjmHvogvnmq0qOv0dkq1uAJ"),
            message.messageId
        )
        Assert.assertEquals("gExZQwJx0PFVPHWPxUg4cXBV5", message.version)
        Assert.assertEquals(5542L, message.messageOffset)
        Assert.assertEquals(
            SysId.create<Types.EntUserId>("eu-JWPE5dBLnZihfOYhn0Bzx3K8m"),
            message.senderId
        )

        Assert.assertTrue(message.payload is com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData)
        val textPayload =
            message.payload as com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData
        Assert.assertEquals("Happy Birthday @Brijesh Dobariya 🎂🎉", textPayload.text)
        Assert.assertNotNull(textPayload.mentionMap)
        Assert.assertEquals(1, textPayload.mentionMap?.size)
        Assert.assertEquals(
            SysId.create<Types.ContactId>("eu-XBEkfLMw9KUbd6GPtH5G2RkTj"),
            textPayload.mentionMap?.get("@Brijesh Dobariya")
        )
    }

    @Test
    fun `deserialize multiple real messages from production`() {
        // Given - Array of real messages from production
        val messagesJson = listOf(
            """{
                "version": "994ibA2V6DqNrH5iGnxuli0DE",
                "messageId": "m-Siosyh8WHnxLQfPskp6W9whd0",
                "messageOffset": 5539,
                "senderId": "eu-KvvdpvCE1ypF4LXmMOadMkpyh",
                "payload": {
                    "text": "I will join office in second half today",
                    "messageType": "text"
                },
                "creationTime": "2026-01-07T03:58:16.178Z"
            }""",
            """{
                "version": "ZS7DmkjXu6YdapWAmG1Qpak2e",
                "messageId": "m-FKMXSBD8kWQQfU9DgCpFQLZug",
                "messageOffset": 5540,
                "senderId": "eu-oUJ8BZtaUuIpDI0lpcCqvFemM",
                "payload": {
                    "text": "Happy Birthday Brijesh! Have a wonderful day!🎊🎂",
                    "messageType": "text"
                },
                "creationTime": "2026-01-07T04:01:46.120Z"
            }""",
            """{
                "version": "gExZQwJx0PFVPHWPxUg4cXBV5",
                "messageId": "m-lPdjmHvogvnmq0qOv0dkq1uAJ",
                "messageOffset": 5542,
                "senderId": "eu-JWPE5dBLnZihfOYhn0Bzx3K8m",
                "payload": {
                    "text": "Happy Birthday @Brijesh Dobariya 🎂🎉",
                    "messageType": "text",
                    "mentionMap": {
                        "@Brijesh Dobariya": "eu-XBEkfLMw9KUbd6GPtH5G2RkTj"
                    }
                },
                "creationTime": "2026-01-07T04:22:26.369Z"
            }"""
        )

        // When - Deserialize all messages
        val messages = messagesJson.map { json.decodeFromString<SigMessageData>(it) }

        // Then - Verify all messages are correctly deserialized
        println("\n=== Deserializing Multiple Real Messages ===")
        Assert.assertEquals(3, messages.size)

        // Verify first message
        val msg1 = messages[0]
        Assert.assertEquals(
            SysId.create<Types.MessageId>("m-Siosyh8WHnxLQfPskp6W9whd0"),
            msg1.messageId
        )
        Assert.assertEquals(5539L, msg1.messageOffset)
        Assert.assertTrue(msg1.payload is com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData)
        Assert.assertEquals(
            "I will join office in second half today",
            (msg1.payload as com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData).text
        )

        // Verify message with mention
        val msg3 = messages[2]
        Assert.assertEquals(
            SysId.create<Types.MessageId>("m-lPdjmHvogvnmq0qOv0dkq1uAJ"),
            msg3.messageId
        )
        Assert.assertTrue(msg3.payload is com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData)
        val textPayload = msg3.payload as com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData
        Assert.assertNotNull(textPayload.mentionMap)
        Assert.assertEquals(1, textPayload.mentionMap?.size)

        // Verify all messages have correct structure
        messages.forEach { message ->
            Assert.assertNotNull(message.messageId)
            Assert.assertNotNull(message.creationTime)
            Assert.assertNotNull(message.senderId)
            Assert.assertTrue(message.payload is com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData)
            println("✓ Message ${message.messageId} deserialized successfully")
        }
        println("============================================\n")
    }
}








