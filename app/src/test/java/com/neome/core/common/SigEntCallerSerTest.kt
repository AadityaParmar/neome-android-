package com.neome.core.common

import com.neome.core.common.serializer.api.ent.entDrawer.sig.SigEntCallerData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.File

/**
 * Comprehensive test class for SigEntCallerData serialization and deserialization.
 * Tests roundtrip JSON -> Kotlin -> JSON -> Kotlin and compares all unique data class properties.
 */
class SigEntCallerSerTest {

    private lateinit var json: Json

    @Before
    fun setup() {
        json = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
            serializersModule = SerializersModule {}
        }
    }

    /**
     * Loads the JSON file from the test resources directory.
     */
    private fun loadJsonFromFile(): String {
        val resourcePath = javaClass.getResource("/com/neome/core/common/SigEntCaller.json")
            ?: throw IllegalStateException("SigEntCaller.json not found in test resources")
        return File(resourcePath.toURI()).readText()
    }

    /**
     * Alternative method to load JSON using direct file path for test directory.
     */
    private fun loadJsonFromTestDir(): String {
        // Get the path relative to the project root
        val testDir = System.getProperty("user.dir")

        // Try multiple possible paths since working directory may vary
        val possiblePaths = listOf(
            "$testDir/app/src/test/java/com/neome/core/common/SigEntCaller.json",
            "$testDir/src/test/java/com/neome/core/common/SigEntCaller.json"
        )

        val jsonFile = possiblePaths.map { File(it) }.find { it.exists() }
            ?: throw IllegalArgumentException(
                "SigEntCaller.json not found. Tried paths:\n${possiblePaths.joinToString("\n")}"
            )

        return jsonFile.readText()
    }

    // ==========================================
    // ROUNDTRIP SERIALIZATION/DESERIALIZATION TEST
    // ==========================================

    @Test
    fun `deserialize and serialize SigEntCallerData roundtrip`() {
        // Given - Load JSON from file
        val jsonString = loadJsonFromTestDir()

        // When - First deserialization
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        println("\n=== First Deserialization Complete ===")
        println("EntId: ${original.entId}")
        println("callerEnt: ${original}")
        println("EntUserId: ${original.entUserId}")
        println("Handle: ${original.handle}")
        println("NickName: ${original.nickName}")

        // When - Serialize back to JSON
        val serializedJson = json.encodeToString(original)
        println("\n=== Serialization Complete (${serializedJson.length} chars) ===")

        // When - Second deserialization
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)
        println("\n=== Second Deserialization Complete ===")

        // Then - Compare all properties
        assertSigEntCallerDataEquals(original, roundtrip)
        println("\n=== All Assertions Passed ===\n")
    }

    @Test
    fun `verify all primitive properties after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then - Compare primitive/simple properties
        assertEquals("version mismatch", original.version, roundtrip.version)
        assertEquals("avatarId mismatch", original.avatarId, roundtrip.avatarId)
        assertEquals("color mismatch", original.color, roundtrip.color)
        assertEquals("displayDateFormat mismatch", original.displayDateFormat, roundtrip.displayDateFormat)
        assertEquals("entId mismatch", original.entId, roundtrip.entId)
        assertEquals("entUserId mismatch", original.entUserId, roundtrip.entUserId)
        assertEquals("entUserIdHash mismatch", original.entUserIdHash, roundtrip.entUserIdHash)
        assertEquals("grandManagerId mismatch", original.grandManagerId, roundtrip.grandManagerId)
        assertEquals("handle mismatch", original.handle, roundtrip.handle)
        assertEquals("languageKey mismatch", original.languageKey, roundtrip.languageKey)
        assertEquals("locationAccuracy mismatch", original.locationAccuracy, roundtrip.locationAccuracy)
        assertEquals("managerId mismatch", original.managerId, roundtrip.managerId)
        assertEquals("nickName mismatch", original.nickName, roundtrip.nickName)
        assertEquals("timeZone mismatch", original.timeZone, roundtrip.timeZone)
        assertEquals("userId mismatch", original.userId, roundtrip.userId)

        println("All primitive properties match!")
    }

    @Test
    fun `verify actionMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        assertEquals("actionMap size mismatch", original.actionMap.size, roundtrip.actionMap.size)
        assertEquals("actionMap keys mismatch", original.actionMap.keys, roundtrip.actionMap.keys)

        original.actionMap.forEach { (key, originalAction) ->
            val roundtripAction = roundtrip.actionMap[key]
            assertNotNull("Action missing for key: $key", roundtripAction)
            assertEquals("Action actionId mismatch for $key", originalAction.actionId, roundtripAction!!.actionId)
            assertEquals("Action name mismatch for $key", originalAction.name, roundtripAction.name)
        }

        println("actionMap verified: ${original.actionMap.size} actions")
    }

    @Test
    fun `verify deeplinkMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.deeplinkMap != null) {
            assertNotNull("deeplinkMap should not be null", roundtrip.deeplinkMap)
            assertEquals("deeplinkMap size mismatch", original.deeplinkMap!!.size, roundtrip.deeplinkMap!!.size)
            assertEquals("deeplinkMap keys mismatch", original.deeplinkMap!!.keys, roundtrip.deeplinkMap!!.keys)

            original.deeplinkMap!!.forEach { (key, originalDeeplink) ->
                val roundtripDeeplink = roundtrip.deeplinkMap!![key]
                assertNotNull("Deeplink missing for key: $key", roundtripDeeplink)
                assertEquals(
                    "Deeplink deepLinkId mismatch for $key",
                    originalDeeplink.deepLinkId,
                    roundtripDeeplink!!.deepLinkId
                )
                assertEquals("Deeplink name mismatch for $key", originalDeeplink.name, roundtripDeeplink.name)
            }
            println("deeplinkMap verified: ${original.deeplinkMap!!.size} deeplinks")
        } else {
            assertEquals("deeplinkMap should both be null", original.deeplinkMap, roundtrip.deeplinkMap)
            println("deeplinkMap is null in both")
        }
    }

    @Test
    fun `verify formMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        assertEquals("formMap size mismatch", original.formMap.size, roundtrip.formMap.size)
        assertEquals("formMap keys mismatch", original.formMap.keys, roundtrip.formMap.keys)

        original.formMap.forEach { (key, originalForm) ->
            val roundtripForm = roundtrip.formMap[key]
            assertNotNull("Form missing for key: $key", roundtripForm)
            assertEquals("Form metaId mismatch for $key", originalForm.metaId, roundtripForm!!.metaId)
            assertEquals("Form name mismatch for $key", originalForm.name, roundtripForm.name)
            assertEquals("Form compMap size mismatch for $key", originalForm.compMap.size, roundtripForm.compMap.size)
            assertEquals("Form compMap keys mismatch for $key", originalForm.compMap.keys, roundtripForm.compMap.keys)
        }

        println("formMap verified: ${original.formMap.size} forms")
    }

    @Test
    fun `verify groupMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then - groupMap is DtoEntGroupMapData
        assertEquals(
            "groupMap.entGroupMap size mismatch",
            original.groupMap.entGroupMap.size, roundtrip.groupMap.entGroupMap.size
        )
        assertEquals(
            "groupMap.entGroupMap keys mismatch",
            original.groupMap.entGroupMap.keys, roundtrip.groupMap.entGroupMap.keys
        )

        println("groupMap verified: ${original.groupMap.entGroupMap.size} groups")
    }

    @Test
    fun `verify groupIdMapping after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        assertEquals("groupIdMapping size mismatch", original.groupIdMapping.size, roundtrip.groupIdMapping.size)
        assertEquals("groupIdMapping mismatch", original.groupIdMapping, roundtrip.groupIdMapping)

        println("groupIdMapping verified: ${original.groupIdMapping.size} mappings")
    }

    @Test
    fun `verify roleIdSet after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        assertEquals("roleIdSet size mismatch", original.roleIdSet.size, roundtrip.roleIdSet.size)
        assertEquals("roleIdSet mismatch", original.roleIdSet, roundtrip.roleIdSet)

        println("roleIdSet verified: ${original.roleIdSet.size} roles")
    }

    @Test
    fun `verify roleMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        assertEquals("roleMap size mismatch", original.roleMap.size, roundtrip.roleMap.size)
        assertEquals("roleMap keys mismatch", original.roleMap.keys, roundtrip.roleMap.keys)

        original.roleMap.forEach { (key, originalRole) ->
            val roundtripRole = roundtrip.roleMap[key]
            assertNotNull("Role missing for key: $key", roundtripRole)
            assertEquals("Role roleId mismatch for $key", originalRole.roleId, roundtripRole!!.roleId)
            assertEquals("Role name mismatch for $key", originalRole.name, roundtripRole.name)
        }

        println("roleMap verified: ${original.roleMap.size} roles")
    }

    @Test
    fun `verify spreadsheetMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.spreadsheetMap != null) {
            assertNotNull("spreadsheetMap should not be null", roundtrip.spreadsheetMap)
            assertEquals(
                "spreadsheetMap size mismatch",
                original.spreadsheetMap!!.size,
                roundtrip.spreadsheetMap!!.size
            )
            assertEquals(
                "spreadsheetMap keys mismatch",
                original.spreadsheetMap!!.keys,
                roundtrip.spreadsheetMap!!.keys
            )

            original.spreadsheetMap!!.forEach { (key, originalSpreadsheet) ->
                val roundtripSpreadsheet = roundtrip.spreadsheetMap!![key]
                assertNotNull("Spreadsheet missing for key: $key", roundtripSpreadsheet)
                assertEquals(
                    "Spreadsheet sheetIdHash mismatch for $key",
                    originalSpreadsheet.sheetIdHash,
                    roundtripSpreadsheet!!.sheetIdHash
                )
                assertEquals("Spreadsheet name mismatch for $key", originalSpreadsheet.name, roundtripSpreadsheet.name)
            }
            println("spreadsheetMap verified: ${original.spreadsheetMap!!.size} spreadsheets")
        } else {
            assertEquals("spreadsheetMap should both be null", original.spreadsheetMap, roundtrip.spreadsheetMap)
            println("spreadsheetMap is null in both")
        }
    }

    @Test
    fun `verify promptMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.promptMap != null) {
            assertNotNull("promptMap should not be null", roundtrip.promptMap)
            assertEquals("promptMap size mismatch", original.promptMap!!.size, roundtrip.promptMap!!.size)
            assertEquals("promptMap keys mismatch", original.promptMap!!.keys, roundtrip.promptMap!!.keys)
            println("promptMap verified: ${original.promptMap!!.size} prompts")
        } else {
            assertEquals("promptMap should both be null", original.promptMap, roundtrip.promptMap)
            println("promptMap is null in both")
        }
    }

    @Test
    fun `verify layoutUserMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.layoutUserMap != null) {
            assertNotNull("layoutUserMap should not be null", roundtrip.layoutUserMap)
            println("layoutUserMap verified")
        } else {
            assertEquals("layoutUserMap should both be null", original.layoutUserMap, roundtrip.layoutUserMap)
            println("layoutUserMap is null in both")
        }
    }

    @Test
    fun `verify layoutUserMenuActionMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.layoutUserMenuActionMap != null) {
            assertNotNull("layoutUserMenuActionMap should not be null", roundtrip.layoutUserMenuActionMap)
            assertEquals(
                "layoutUserMenuActionMap size mismatch",
                original.layoutUserMenuActionMap!!.size, roundtrip.layoutUserMenuActionMap!!.size
            )
            assertEquals(
                "layoutUserMenuActionMap keys mismatch",
                original.layoutUserMenuActionMap!!.keys, roundtrip.layoutUserMenuActionMap!!.keys
            )
            println("layoutUserMenuActionMap verified: ${original.layoutUserMenuActionMap!!.size} actions")
        } else {
            assertEquals(
                "layoutUserMenuActionMap should both be null",
                original.layoutUserMenuActionMap, roundtrip.layoutUserMenuActionMap
            )
            println("layoutUserMenuActionMap is null in both")
        }
    }

    @Test
    fun `verify locationConfig after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.locationConfig != null) {
            assertNotNull("locationConfig should not be null", roundtrip.locationConfig)
            assertEquals("locationConfig mismatch", original.locationConfig, roundtrip.locationConfig)
            println("locationConfig verified")
        } else {
            assertEquals("locationConfig should both be null", original.locationConfig, roundtrip.locationConfig)
            println("locationConfig is null in both")
        }
    }

    @Test
    fun `verify managerialRelationshipMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.managerialRelationshipMap != null) {
            assertNotNull("managerialRelationshipMap should not be null", roundtrip.managerialRelationshipMap)
            assertEquals(
                "managerialRelationshipMap size mismatch",
                original.managerialRelationshipMap!!.size, roundtrip.managerialRelationshipMap!!.size
            )
            assertEquals(
                "managerialRelationshipMap keys mismatch",
                original.managerialRelationshipMap!!.keys, roundtrip.managerialRelationshipMap!!.keys
            )

            original.managerialRelationshipMap!!.forEach { (key, originalList) ->
                val roundtripList = roundtrip.managerialRelationshipMap!![key]
                assertNotNull("Relationship list missing for key: $key", roundtripList)
                assertEquals("Relationship list size mismatch for $key", originalList.size, roundtripList!!.size)
                assertEquals("Relationship list mismatch for $key", originalList, roundtripList)
            }
            println("managerialRelationshipMap verified: ${original.managerialRelationshipMap!!.size} relationships")
        } else {
            assertEquals(
                "managerialRelationshipMap should both be null",
                original.managerialRelationshipMap, roundtrip.managerialRelationshipMap
            )
            println("managerialRelationshipMap is null in both")
        }
    }

    @Test
    fun `verify paymentProvider after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.paymentProvider != null) {
            assertNotNull("paymentProvider should not be null", roundtrip.paymentProvider)
            println("paymentProvider verified")
        } else {
            assertEquals("paymentProvider should both be null", original.paymentProvider, roundtrip.paymentProvider)
            println("paymentProvider is null in both")
        }
    }

    @Test
    fun `verify userSettingVarMap after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.userSettingVarMap != null) {
            assertNotNull("userSettingVarMap should not be null", roundtrip.userSettingVarMap)
            assertEquals(
                "userSettingVarMap size mismatch",
                original.userSettingVarMap!!.size, roundtrip.userSettingVarMap!!.size
            )
            assertEquals(
                "userSettingVarMap keys mismatch",
                original.userSettingVarMap!!.keys, roundtrip.userSettingVarMap!!.keys
            )
            println("userSettingVarMap verified: ${original.userSettingVarMap!!.size} settings")
        } else {
            assertEquals(
                "userSettingVarMap should both be null",
                original.userSettingVarMap,
                roundtrip.userSettingVarMap
            )
            println("userSettingVarMap is null in both")
        }
    }

    @Test
    fun `verify wallpaper after roundtrip`() {
        // Given
        val jsonString = loadJsonFromTestDir()
        val original = json.decodeFromString<SigEntCallerData>(jsonString)
        val serializedJson = json.encodeToString(original)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Then
        if (original.wallpaper != null) {
            assertNotNull("wallpaper should not be null", roundtrip.wallpaper)
            println("wallpaper verified")
        } else {
            assertEquals("wallpaper should both be null", original.wallpaper, roundtrip.wallpaper)
            println("wallpaper is null in both")
        }
    }

    // ==========================================
    // HELPER METHODS
    // ==========================================

    /**
     * Comprehensive comparison of all SigEntCallerData properties.
     * Compares only unique instances of data class properties.
     */
    private fun assertSigEntCallerDataEquals(original: SigEntCallerData, roundtrip: SigEntCallerData) {
        // Simple/primitive properties
        assertEquals("version mismatch", original.version, roundtrip.version)
        assertEquals("avatarId mismatch", original.avatarId, roundtrip.avatarId)
        assertEquals("color mismatch", original.color, roundtrip.color)
        assertEquals("displayDateFormat mismatch", original.displayDateFormat, roundtrip.displayDateFormat)
        assertEquals("entId mismatch", original.entId, roundtrip.entId)
        assertEquals("entUserId mismatch", original.entUserId, roundtrip.entUserId)
        assertEquals("entUserIdHash mismatch", original.entUserIdHash, roundtrip.entUserIdHash)
        assertEquals("grandManagerId mismatch", original.grandManagerId, roundtrip.grandManagerId)
        assertEquals("handle mismatch", original.handle, roundtrip.handle)
        assertEquals("languageKey mismatch", original.languageKey, roundtrip.languageKey)
        assertEquals("locationAccuracy mismatch", original.locationAccuracy, roundtrip.locationAccuracy)
        assertEquals("managerId mismatch", original.managerId, roundtrip.managerId)
        assertEquals("nickName mismatch", original.nickName, roundtrip.nickName)
        assertEquals("timeZone mismatch", original.timeZone, roundtrip.timeZone)
        assertEquals("userId mismatch", original.userId, roundtrip.userId)

        // List properties
        assertEquals("roleIdSet mismatch", original.roleIdSet, roundtrip.roleIdSet)

        // Map properties - compare sizes and keys
        assertEquals("actionMap size mismatch", original.actionMap.size, roundtrip.actionMap.size)
        assertEquals("actionMap keys mismatch", original.actionMap.keys, roundtrip.actionMap.keys)

        assertEquals("formMap size mismatch", original.formMap.size, roundtrip.formMap.size)
        assertEquals("formMap keys mismatch", original.formMap.keys, roundtrip.formMap.keys)

        assertEquals("groupIdMapping mismatch", original.groupIdMapping, roundtrip.groupIdMapping)

        assertEquals("roleMap size mismatch", original.roleMap.size, roundtrip.roleMap.size)
        assertEquals("roleMap keys mismatch", original.roleMap.keys, roundtrip.roleMap.keys)

        // Nullable map properties
        assertNullableMapEquals("deeplinkMap", original.deeplinkMap, roundtrip.deeplinkMap)
        assertNullableMapEquals("spreadsheetMap", original.spreadsheetMap, roundtrip.spreadsheetMap)
        assertNullableMapEquals("promptMap", original.promptMap, roundtrip.promptMap)
        assertNullableMapEquals(
            "layoutUserMenuActionMap",
            original.layoutUserMenuActionMap,
            roundtrip.layoutUserMenuActionMap
        )
        assertNullableMapEquals(
            "managerialRelationshipMap",
            original.managerialRelationshipMap,
            roundtrip.managerialRelationshipMap
        )
        assertNullableMapEquals("userSettingVarMap", original.userSettingVarMap, roundtrip.userSettingVarMap)

        // Data class properties - compare key identifying fields
        assertGroupMapEquals(original.groupMap, roundtrip.groupMap)

        // Nullable data class properties
        assertNullableEquals("layoutUserMap", original.layoutUserMap, roundtrip.layoutUserMap)
        assertNullableEquals("locationConfig", original.locationConfig, roundtrip.locationConfig)
        assertNullableEquals("paymentProvider", original.paymentProvider, roundtrip.paymentProvider)
        assertNullableEquals("wallpaper", original.wallpaper, roundtrip.wallpaper)
    }

    private fun <K, V> assertNullableMapEquals(name: String, original: Map<K, V>?, roundtrip: Map<K, V>?) {
        if (original == null) {
            assertEquals("$name should both be null", original, roundtrip)
        } else {
            assertNotNull("$name should not be null", roundtrip)
            assertEquals("$name size mismatch", original.size, roundtrip!!.size)
            assertEquals("$name keys mismatch", original.keys, roundtrip.keys)
        }
    }

    private fun <T> assertNullableEquals(name: String, original: T?, roundtrip: T?) {
        if (original == null) {
            assertEquals("$name should both be null", original, roundtrip)
        } else {
            assertNotNull("$name should not be null", roundtrip)
        }
    }

    private fun assertGroupMapEquals(
        original: com.neome.core.common.serializer.api.ent.base.dto.DtoEntGroupMapData,
        roundtrip: com.neome.core.common.serializer.api.ent.base.dto.DtoEntGroupMapData
    ) {
        assertEquals("groupMap.entGroupMap size mismatch", original.entGroupMap.size, roundtrip.entGroupMap.size)
        assertEquals("groupMap.entGroupMap keys mismatch", original.entGroupMap.keys, roundtrip.entGroupMap.keys)
    }
}
