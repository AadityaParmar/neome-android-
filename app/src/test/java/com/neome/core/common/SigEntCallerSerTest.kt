package com.neome.core.common

import com.neome.core.common.serializer.api.ent.entDrawer.sig.SigEntCallerData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import kotlinx.serialization.modules.SerializersModule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.File

/**
 * Comprehensive test class for SigEntCallerData serialization and deserialization.
 * Tests each nested property by comparing deserialized data with original JSON using JsonElement.
 */
class SigEntCallerSerTest {

    private lateinit var json: Json
    private lateinit var jsonString: String
    private lateinit var jsonElement: JsonElement
    private lateinit var deserialized: SigEntCallerData

    @Before
    fun setup() {
        json = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
            serializersModule = SerializersModule {}
        }

        // Load JSON and parse as JsonElement
        jsonString = loadJsonFromTestDir()
        jsonElement = json.parseToJsonElement(jsonString)
        deserialized = json.decodeFromString<SigEntCallerData>(jsonString)
        val str = json.encodeToString(deserialized)
    }

    private fun loadJsonFromTestDir(): String {
        val testDir = System.getProperty("user.dir")
        val possiblePaths = listOf(
            "$testDir/app/src/test/java/com/neome/core/common/SigEntCaller2.json",
            "$testDir/src/test/java/com/neome/core/common/SigEntCaller2.json"
        )
        val jsonFile = possiblePaths.map { File(it) }.find { it.exists() }
            ?: throw IllegalArgumentException(
                "SigEntCaller.json not found. Tried paths:\n${possiblePaths.joinToString("\n")}"
            )
        return jsonFile.readText()
    }

    private val rootJson: JsonObject get() = jsonElement.jsonObject

    // ==========================================
    // PRIMITIVE PROPERTY TESTS - Compare with JSON
    // ==========================================

    @Test
    fun `verify entId matches JSON`() {
        val jsonValue = rootJson["entId"]?.jsonPrimitive?.content
        assertEquals("entId mismatch with JSON", jsonValue, deserialized.entId.toString())
        println("entId verified: $jsonValue")
    }

    @Test
    fun `verify entUserId matches JSON`() {
        val jsonValue = rootJson["entUserId"]?.jsonPrimitive?.content
        assertEquals("entUserId mismatch with JSON", jsonValue, deserialized.entUserId.toString())
        println("entUserId verified: $jsonValue")
    }

    @Test
    fun `verify avatarId matches JSON`() {
        val jsonValue = rootJson["avatarId"]?.jsonPrimitive?.contentOrNull
        if (jsonValue != null) {
            assertEquals("avatarId mismatch with JSON", jsonValue, deserialized.avatarId?.toString())
        } else {
            assertEquals("avatarId should be null", null, deserialized.avatarId)
        }
        println("avatarId verified: $jsonValue")
    }

    @Test
    fun `verify entUserIdHash matches JSON`() {
        val jsonValue = rootJson["entUserIdHash"]?.jsonPrimitive?.content
        assertEquals("entUserIdHash mismatch with JSON", jsonValue, deserialized.entUserIdHash)
        println("entUserIdHash verified: $jsonValue")
    }

    @Test
    fun `verify color matches JSON`() {
        val jsonValue = rootJson["color"]?.jsonPrimitive?.content
        assertEquals("color mismatch with JSON", jsonValue, deserialized.color)
        println("color verified: $jsonValue")
    }

    @Test
    fun `verify handle matches JSON`() {
        val jsonValue = rootJson["handle"]?.jsonPrimitive?.content
        assertEquals("handle mismatch with JSON", jsonValue, deserialized.handle)
        println("handle verified: $jsonValue")
    }

    @Test
    fun `verify nickName matches JSON`() {
        val jsonValue = rootJson["nickName"]?.jsonPrimitive?.content
        assertEquals("nickName mismatch with JSON", jsonValue, deserialized.nickName)
        println("nickName verified: $jsonValue")
    }

    @Test
    fun `verify userId matches JSON`() {
        val jsonValue = rootJson["userId"]?.jsonPrimitive?.content
        assertEquals("userId mismatch with JSON", jsonValue, deserialized.userId.toString())
        println("userId verified: $jsonValue")
    }

    @Test
    fun `verify version matches JSON`() {
        val jsonValue = rootJson["version"]?.jsonPrimitive?.content
        assertEquals("version mismatch with JSON", jsonValue, deserialized.version)
        println("version verified: $jsonValue")
    }

    // ==========================================
    // ROLEIDSET - Compare each element with JSON
    // ==========================================

    @Test
    fun `verify roleIdSet matches JSON`() {
        val jsonArray = rootJson["roleIdSet"]?.jsonArray
        assertNotNull("roleIdSet should exist in JSON", jsonArray)

        assertEquals("roleIdSet size mismatch", jsonArray!!.size, deserialized.roleIdSet.size)

        jsonArray.forEachIndexed { index, element ->
            val jsonValue = element.jsonPrimitive.content
            val deserializedValue = deserialized.roleIdSet.elementAt(index).toString()
            assertEquals("roleIdSet[$index] mismatch", jsonValue, deserializedValue)
        }
        println("roleIdSet verified: ${jsonArray.size} items")
    }

    // ==========================================
    // GROUP ID MAPPING - Compare each entry with JSON
    // ==========================================

    @Test
    fun `verify groupIdMapping matches JSON`() {
        val jsonMap = rootJson["groupIdMapping"]?.jsonObject
        assertNotNull("groupIdMapping should exist in JSON", jsonMap)

        assertEquals("groupIdMapping size mismatch", jsonMap!!.size, deserialized.groupIdMapping.size)

        jsonMap.forEach { (key, value) ->
            val jsonValue = value.jsonPrimitive.content
            val deserializedEntry = deserialized.groupIdMapping.entries.find { it.key.toString() == key }
            assertNotNull("groupIdMapping missing key: $key", deserializedEntry)
            assertEquals(
                "groupIdMapping[$key] mismatch",
                jsonValue,
                deserializedEntry!!.value.toString()
            )
        }
        println("groupIdMapping verified: ${jsonMap.size} mappings")
    }

    // ==========================================
    // ACTION MAP - Compare each action with JSON
    // ==========================================

    @Test
    fun `verify actionMap matches JSON`() {
        val jsonMap = rootJson["actionMap"]?.jsonObject
        assertNotNull("actionMap should exist in JSON", jsonMap)

        assertEquals("actionMap size mismatch", jsonMap!!.size, deserialized.actionMap.size)

        jsonMap.forEach { (key, actionJson) ->
            val actionObj = actionJson.jsonObject
            val deserializedAction = deserialized.actionMap.entries.find { it.key.toString() == key }
            assertNotNull("actionMap missing key: $key", deserializedAction)

            val action = deserializedAction!!.value

            // Verify each property of the action
            assertJsonEquals("actionMap[$key].actionId", actionObj["actionId"], action.actionId.toString())
            assertJsonEquals("actionMap[$key].name", actionObj["name"], action.name.toString())
            assertJsonEquals("actionMap[$key].kind", actionObj["kind"], action.kind.name)
            assertJsonEqualsNullable("actionMap[$key].label", actionObj["label"], action.label)
            assertJsonEqualsNullable("actionMap[$key].description", actionObj["description"], action.description)
            assertJsonEqualsNullable("actionMap[$key].icon", actionObj["icon"], action.icon)
            assertJsonEqualsNullable("actionMap[$key].tooltip", actionObj["tooltip"], action.tooltip)
            assertJsonEqualsNullableBoolean(
                "actionMap[$key].increaseAsideWidth",
                actionObj["increaseAsideWidth"],
                action.increaseAsideWidth
            )
        }
        println("actionMap verified: ${jsonMap.size} actions with all nested properties")
    }

    // ==========================================
    // ROLE MAP - Compare each role with JSON
    // ==========================================

    @Test
    fun `verify roleMap matches JSON`() {
        val jsonMap = rootJson["roleMap"]?.jsonObject
        assertNotNull("roleMap should exist in JSON", jsonMap)

        assertEquals("roleMap size mismatch", jsonMap!!.size, deserialized.roleMap.size)

        jsonMap.forEach { (key, roleJson) ->
            val roleObj = roleJson.jsonObject
            val deserializedRole = deserialized.roleMap.entries.find { it.key.toString() == key }
            assertNotNull("roleMap missing key: $key", deserializedRole)

            val role = deserializedRole!!.value

            // Verify each property of the role
            assertJsonEquals("roleMap[$key].roleId", roleObj["roleId"], role.roleId.toString())
            assertJsonEquals("roleMap[$key].name", roleObj["name"], role.name.toString())
            assertJsonEqualsNullable("roleMap[$key].label", roleObj["label"], role.label)
            assertJsonEqualsNullable("roleMap[$key].description", roleObj["description"], role.description)
        }
        println("roleMap verified: ${jsonMap.size} roles with all nested properties")
    }

    // ==========================================
    // DEEPLINK MAP - Compare each deeplink with JSON
    // ==========================================

    @Test
    fun `verify deeplinkMap matches JSON`() {
        val jsonMap = rootJson["deeplinkMap"]?.jsonObject

        if (jsonMap == null || jsonMap.isEmpty()) {
            assertTrue(
                "deeplinkMap should be null or empty",
                deserialized.deeplinkMap == null || deserialized.deeplinkMap!!.isEmpty()
            )
            println("deeplinkMap is null/empty in both")
            return
        }

        assertNotNull("deeplinkMap should not be null", deserialized.deeplinkMap)
        assertEquals("deeplinkMap size mismatch", jsonMap.size, deserialized.deeplinkMap!!.size)

        jsonMap.forEach { (key, deeplinkJson) ->
            val deeplinkObj = deeplinkJson.jsonObject
            val deserializedDeeplink = deserialized.deeplinkMap!!.entries.find { it.key.toString() == key }
            assertNotNull("deeplinkMap missing key: $key", deserializedDeeplink)

            val deeplink = deserializedDeeplink!!.value

            // Verify each property of the deeplink
            assertJsonEquals("deeplinkMap[$key].deepLinkId", deeplinkObj["deepLinkId"], deeplink.deepLinkId.toString())
            assertJsonEquals("deeplinkMap[$key].name", deeplinkObj["name"], deeplink.name.toString())
            assertJsonEquals("deeplinkMap[$key].kind", deeplinkObj["kind"], deeplink.kind.name)
            assertJsonEqualsNullable("deeplinkMap[$key].description", deeplinkObj["description"], deeplink.description)

            // Verify modules if present
            val modulesJson = deeplinkObj["modules"]
            if (modulesJson != null && modulesJson !is JsonNull) {
                assertNotNull("deeplinkMap[$key].modules should not be null", deeplink.modules)
            }
        }
        println("deeplinkMap verified: ${jsonMap.size} deeplinks with all nested properties")
    }

    // ==========================================
    // SPREADSHEET MAP - Compare each spreadsheet with JSON
    // ==========================================

    @Test
    fun `verify spreadsheetMap matches JSON`() {
        val jsonMap = rootJson["spreadsheetMap"]?.jsonObject

        if (jsonMap == null || jsonMap.isEmpty()) {
            assertTrue(
                "spreadsheetMap should be null or empty",
                deserialized.spreadsheetMap == null || deserialized.spreadsheetMap!!.isEmpty()
            )
            println("spreadsheetMap is null/empty in both")
            return
        }

        assertNotNull("spreadsheetMap should not be null", deserialized.spreadsheetMap)
        assertEquals("spreadsheetMap size mismatch", jsonMap.size, deserialized.spreadsheetMap!!.size)

        jsonMap.forEach { (key, spreadsheetJson) ->
            val spreadsheetObj = spreadsheetJson.jsonObject
            val deserializedSpreadsheet = deserialized.spreadsheetMap!!.entries.find { it.key.toString() == key }
            assertNotNull("spreadsheetMap missing key: $key", deserializedSpreadsheet)

            val spreadsheet = deserializedSpreadsheet!!.value

            // Verify each property of the spreadsheet
            assertJsonEquals("spreadsheetMap[$key].name", spreadsheetObj["name"], spreadsheet.name.toString())
            assertJsonEquals("spreadsheetMap[$key].sheetIdHash", spreadsheetObj["sheetIdHash"], spreadsheet.sheetIdHash)
            assertJsonEquals(
                "spreadsheetMap[$key].spreadsheetFormId",
                spreadsheetObj["spreadsheetFormId"],
                spreadsheet.spreadsheetFormId.toString()
            )
            assertJsonEqualsNullable("spreadsheetMap[$key].label", spreadsheetObj["label"], spreadsheet.label)
            assertJsonEqualsBoolean("spreadsheetMap[$key].canClear", spreadsheetObj["canClear"], spreadsheet.canClear)
            assertJsonEqualsBoolean(
                "spreadsheetMap[$key].canExpire",
                spreadsheetObj["canExpire"],
                spreadsheet.canExpire
            )
            assertJsonEqualsBoolean(
                "spreadsheetMap[$key].hasPartition",
                spreadsheetObj["hasPartition"],
                spreadsheet.hasPartition
            )
            assertJsonEqualsBoolean(
                "spreadsheetMap[$key].supportOffline",
                spreadsheetObj["supportOffline"],
                spreadsheet.supportOffline
            )

            // Verify role id sets
            verifyJsonArray(
                "spreadsheetMap[$key].insertRoleIdSet",
                spreadsheetObj["insertRoleIdSet"],
                spreadsheet.insertRoleIdSet?.map { it.toString() } ?: emptyList()
            )
            verifyJsonArray(
                "spreadsheetMap[$key].updateRoleIdSet",
                spreadsheetObj["updateRoleIdSet"],
                spreadsheet.updateRoleIdSet?.map { it.toString() } ?: emptyList()
            )
            verifyJsonArray(
                "spreadsheetMap[$key].removeRoleIdSet",
                spreadsheetObj["removeRoleIdSet"],
                spreadsheet.removeRoleIdSet?.map { it.toString() } ?: emptyList()
            )
            verifyJsonArray(
                "spreadsheetMap[$key].forwardRoleIdSet",
                spreadsheetObj["forwardRoleIdSet"],
                spreadsheet.forwardRoleIdSet?.map { it.toString() } ?: emptyList()
            )
        }
        println("spreadsheetMap verified: ${jsonMap.size} spreadsheets with all nested properties")
    }

    // ==========================================
    // FORM MAP - Compare each form with JSON
    // ==========================================

    @Test
    fun `verify formMap matches JSON`() {
        val jsonMap = rootJson["formMap"]?.jsonObject
        assertNotNull("formMap should exist in JSON", jsonMap)

        assertEquals("formMap size mismatch", jsonMap!!.size, deserialized.formMap.size)

        jsonMap.forEach { (key, formJson) ->
            val formObj = formJson.jsonObject
            val deserializedForm = deserialized.formMap.entries.find { it.key.toString() == key }
            assertNotNull("formMap missing key: $key", deserializedForm)

            val form = deserializedForm!!.value

            // Verify each property of the form
            assertJsonEquals("formMap[$key].metaId", formObj["metaId"], form.metaId.toString())
            assertJsonEquals("formMap[$key].name", formObj["name"], form.name.toString())
            assertJsonEqualsNullable("formMap[$key].label", formObj["label"], form.label)

            // Verify compMap
            val compMapJson = formObj["compMap"]?.jsonObject
            if (compMapJson != null) {
                assertEquals(
                    "formMap[$key].compMap size mismatch",
                    compMapJson.size,
                    form.compMap.size
                )

                // Verify each component in compMap
                compMapJson.forEach { (compKey, compJson) ->
                    val compObj = compJson.jsonObject
                    val deserializedComp = form.compMap.entries.find { it.key.toString() == compKey }
                    assertNotNull("formMap[$key].compMap missing key: $compKey", deserializedComp)

                    val comp = deserializedComp!!.value

                    // Verify common component properties available on DefnComp interface
                    assertJsonEquals(
                        "formMap[$key].compMap[$compKey].name",
                        compObj["name"],
                        comp.name.toString()
                    )
                    assertJsonEquals(
                        "formMap[$key].compMap[$compKey].type",
                        compObj["type"],
                        comp.type.name
                    )
                    assertJsonEqualsNullable(
                        "formMap[$key].compMap[$compKey].label",
                        compObj["label"],
                        comp.label
                    )
                }
            }

            // Verify displayCompositeId
            assertJsonEqualsNullable(
                "formMap[$key].displayCompositeId",
                formObj["displayCompositeId"],
                form.displayCompositeId?.toString()
            )
        }
        println("formMap verified: ${jsonMap.size} forms with all nested properties")
    }

    // ==========================================
    // GROUP MAP - Compare each group with JSON
    // ==========================================

    @Test
    fun `verify groupMap matches JSON`() {
        val jsonMap = rootJson["groupMap"]?.jsonObject
        assertNotNull("groupMap should exist in JSON", jsonMap)

        val entGroupMapJson = jsonMap!!["entGroupMap"]?.jsonObject
        assertNotNull("groupMap.entGroupMap should exist in JSON", entGroupMapJson)

        assertEquals(
            "groupMap.entGroupMap size mismatch",
            entGroupMapJson!!.size,
            deserialized.groupMap.entGroupMap.size
        )

        entGroupMapJson.forEach { (key, groupJson) ->
            val groupObj = groupJson.jsonObject
            val deserializedGroup = deserialized.groupMap.entGroupMap.entries.find { it.key.toString() == key }
            assertNotNull("groupMap.entGroupMap missing key: $key", deserializedGroup)

            val group = deserializedGroup!!.value

            // Verify each property of the group (DtoEntGroupData)
            assertJsonEqualsNullableBoolean("groupMap.entGroupMap[$key].freeze", groupObj["freeze"], group.freeze)
            assertJsonEqualsNullable(
                "groupMap.entGroupMap[$key].freezeAvatarKind",
                groupObj["freezeAvatarKind"],
                group.freezeAvatarKind?.name
            )
            assertJsonEqualsNullable(
                "groupMap.entGroupMap[$key].freezeSortName",
                groupObj["freezeSortName"],
                group.freezeSortName
            )
        }
        println("groupMap verified: ${entGroupMapJson.size} groups with all nested properties")
    }

    // ==========================================
    // PROMPT MAP - Compare each prompt with JSON
    // ==========================================

    @Test
    fun `verify promptMap matches JSON`() {
        val jsonMap = rootJson["promptMap"]?.jsonObject

        if (jsonMap == null || jsonMap.isEmpty()) {
            assertTrue(
                "promptMap should be null or empty",
                deserialized.promptMap == null || deserialized.promptMap!!.isEmpty()
            )
            println("promptMap is null/empty in both")
            return
        }

        assertNotNull("promptMap should not be null", deserialized.promptMap)
        assertEquals("promptMap size mismatch", jsonMap.size, deserialized.promptMap!!.size)

        jsonMap.forEach { (key, promptJson) ->
            val promptObj = promptJson.jsonObject
            val deserializedPrompt = deserialized.promptMap!!.entries.find { it.key.toString() == key }
            assertNotNull("promptMap missing key: $key", deserializedPrompt)

            val prompt = deserializedPrompt!!.value

            // Verify each property of the prompt (DtoEntPromptData)
            assertJsonEquals("promptMap[$key].metaId", promptObj["metaId"], prompt.metaId.toString())
            assertJsonEquals("promptMap[$key].name", promptObj["name"], prompt.name.toString())
            assertJsonEquals("promptMap[$key].actionId", promptObj["actionId"], prompt.actionId.toString())
            assertJsonEqualsNullable("promptMap[$key].description", promptObj["description"], prompt.description)
            assertJsonEqualsNullable("promptMap[$key].hint", promptObj["hint"], prompt.hint)
        }
        println("promptMap verified: ${jsonMap.size} prompts with all nested properties")
    }

    // ==========================================
    // MANAGERIAL RELATIONSHIP MAP - Compare with JSON
    // ==========================================

    @Test
    fun `verify managerialRelationshipMap matches JSON`() {
        val jsonMap = rootJson["managerialRelationshipMap"]?.jsonObject

        if (jsonMap == null || jsonMap.isEmpty()) {
            assertTrue(
                "managerialRelationshipMap should be null or empty",
                deserialized.managerialRelationshipMap == null ||
                    deserialized.managerialRelationshipMap!!.isEmpty()
            )
            println("managerialRelationshipMap is null/empty in both")
            return
        }

        assertNotNull("managerialRelationshipMap should not be null", deserialized.managerialRelationshipMap)
        assertEquals(
            "managerialRelationshipMap size mismatch",
            jsonMap.size,
            deserialized.managerialRelationshipMap!!.size
        )

        jsonMap.forEach { (key, listJson) ->
            val jsonArray = listJson.jsonArray
            val deserializedEntry = deserialized.managerialRelationshipMap!!.entries.find { it.key.toString() == key }
            assertNotNull("managerialRelationshipMap missing key: $key", deserializedEntry)

            val list = deserializedEntry!!.value

            assertEquals("managerialRelationshipMap[$key] size mismatch", jsonArray.size, list.size)

            jsonArray.forEachIndexed { index, element ->
                val jsonValue = element.jsonPrimitive.content
                val deserializedValue = list.elementAt(index).toString()
                assertEquals("managerialRelationshipMap[$key][$index] mismatch", jsonValue, deserializedValue)
            }
        }
        println("managerialRelationshipMap verified: ${jsonMap.size} relationships with all nested properties")
    }

    // ==========================================
    // LAYOUT USER MENU ACTION MAP - Compare with JSON
    // ==========================================

    @Test
    fun `verify layoutUserMenuActionMap matches JSON`() {
        val jsonMap = rootJson["layoutUserMenuActionMap"]?.jsonObject

        if (jsonMap == null || jsonMap.isEmpty()) {
            assertTrue(
                "layoutUserMenuActionMap should be null or empty",
                deserialized.layoutUserMenuActionMap == null ||
                    deserialized.layoutUserMenuActionMap!!.isEmpty()
            )
            println("layoutUserMenuActionMap is null/empty in both")
            return
        }

        assertNotNull("layoutUserMenuActionMap should not be null", deserialized.layoutUserMenuActionMap)
        assertEquals("layoutUserMenuActionMap size mismatch", jsonMap.size, deserialized.layoutUserMenuActionMap!!.size)

        jsonMap.forEach { (key, actionPermissionJson) ->
            val actionPermissionObj = actionPermissionJson.jsonObject
            val deserializedEntry = deserialized.layoutUserMenuActionMap!!.entries.find { it.key.toString() == key }
            assertNotNull("layoutUserMenuActionMap missing key: $key", deserializedEntry)

            val actionPermission = deserializedEntry!!.value

            // Verify each property of the action permission (DefnStudioDtoActionPermissionData)
            assertJsonEquals(
                "layoutUserMenuActionMap[$key].metaId",
                actionPermissionObj["metaId"],
                actionPermission.metaId.toString()
            )
            assertJsonEqualsNullableBoolean(
                "layoutUserMenuActionMap[$key].hidden",
                actionPermissionObj["hidden"],
                actionPermission.hidden
            )
            assertJsonEqualsNullable(
                "layoutUserMenuActionMap[$key].menuGroup",
                actionPermissionObj["menuGroup"],
                actionPermission.menuGroup
            )
            assertJsonEqualsNullableBoolean(
                "layoutUserMenuActionMap[$key].showMessageTooltip",
                actionPermissionObj["showMessageTooltip"],
                actionPermission.showMessageTooltip
            )
        }
        println("layoutUserMenuActionMap verified: ${jsonMap.size} action permissions with all nested properties")
    }

    // ==========================================
    // LOCATION CONFIG - Compare with JSON
    // ==========================================

    @Test
    fun `verify locationConfig matches JSON`() {
        val jsonObj = rootJson["locationConfig"]

        if (jsonObj == null || jsonObj is JsonNull) {
            assertEquals("locationConfig should be null", null, deserialized.locationConfig)
            println("locationConfig is null in both")
            return
        }

        assertNotNull("locationConfig should not be null", deserialized.locationConfig)
        val configObj = jsonObj.jsonObject
        val config = deserialized.locationConfig!!

        // Verify locationConfig properties (StudioDtoLocationCaptureData)
        assertJsonEqualsNullable("locationConfig.type", configObj["type"], config.type?.name)
        assertJsonEqualsNullableLong(
            "locationConfig.frequencyBasedOnTime",
            configObj["frequencyBasedOnTime"],
            config.frequencyBasedOnTime
        )
        assertJsonEqualsNullableLong(
            "locationConfig.frequencyBasedOnDistance",
            configObj["frequencyBasedOnDistance"],
            config.frequencyBasedOnDistance
        )
        assertJsonEqualsNullable("locationConfig.fromTime", configObj["fromTime"], config.fromTime?.toString())
        assertJsonEqualsNullable("locationConfig.toTime", configObj["toTime"], config.toTime?.toString())

        println("locationConfig verified with all nested properties")
    }

    // ==========================================
    // LAYOUT USER MAP - Compare with JSON
    // ==========================================

    @Test
    fun `verify layoutUserMap matches JSON`() {
        val jsonObj = rootJson["layoutUserMap"]

        if (jsonObj == null || jsonObj is JsonNull) {
            assertEquals("layoutUserMap should be null", null, deserialized.layoutUserMap)
            println("layoutUserMap is null in both")
            return
        }

        assertNotNull("layoutUserMap should not be null", deserialized.layoutUserMap)
        val layoutObj = jsonObj.jsonObject
        val layout = deserialized.layoutUserMap!!

        // Verify layoutUserMap properties (DefnLayoutUserMapData)
        val keysJson = layoutObj["keys"]?.jsonArray
        if (keysJson != null) {
            assertEquals("layoutUserMap.keys size mismatch", keysJson.size, layout.keys.size)
        }
        val mapJson = layoutObj["map"]?.jsonObject
        if (mapJson != null) {
            assertEquals("layoutUserMap.map size mismatch", mapJson.size, layout.map.size)
        }
        assertJsonEqualsNullable(
            "layoutUserMap.mobileDefaultLayoutId",
            layoutObj["mobileDefaultLayoutId"],
            layout.mobileDefaultLayoutId?.toString()
        )
        assertJsonEqualsNullable(
            "layoutUserMap.webDefaultLayoutId",
            layoutObj["webDefaultLayoutId"],
            layout.webDefaultLayoutId?.toString()
        )

        println("layoutUserMap verified with all nested properties")
    }

    // ==========================================
    // PAYMENT PROVIDER - Compare with JSON
    // ==========================================

    @Test
    fun `verify paymentProvider matches JSON`() {
        val jsonObj = rootJson["paymentProvider"]

        if (jsonObj == null || jsonObj is JsonNull) {
            assertEquals("paymentProvider should be null", null, deserialized.paymentProvider)
            println("paymentProvider is null in both")
            return
        }

        assertNotNull("paymentProvider should not be null", deserialized.paymentProvider)
        println("paymentProvider verified")
    }

    // ==========================================
    // WALLPAPER - Compare with JSON
    // ==========================================

    @Test
    fun `verify wallpaper matches JSON`() {
        val jsonObj = rootJson["wallpaper"]

        if (jsonObj == null || jsonObj is JsonNull) {
            assertEquals("wallpaper should be null", null, deserialized.wallpaper)
            println("wallpaper is null in both")
            return
        }

        assertNotNull("wallpaper should not be null", deserialized.wallpaper)
        val wallpaperObj = jsonObj.jsonObject
        val wallpaper = deserialized.wallpaper!!

        // Verify wallpaper properties (DtoEntWallpaperData)
        assertJsonEqualsNullable(
            "wallpaper.wallpaperImageId",
            wallpaperObj["wallpaperImageId"],
            wallpaper.wallpaperImageId?.toString()
        )
        assertJsonEqualsNullableBoolean("wallpaper.repeatTile", wallpaperObj["repeatTile"], wallpaper.repeatTile)

        println("wallpaper verified with all nested properties")
    }

    // ==========================================
    // USER SETTING VAR MAP - Compare with JSON
    // ==========================================

    @Test
    fun `verify userSettingVarMap matches JSON`() {
        val jsonMap = rootJson["userSettingVarMap"]?.jsonObject

        if (jsonMap == null || jsonMap.isEmpty()) {
            assertTrue(
                "userSettingVarMap should be null or empty",
                deserialized.userSettingVarMap == null ||
                    deserialized.userSettingVarMap!!.isEmpty()
            )
            println("userSettingVarMap is null/empty in both")
            return
        }

        assertNotNull("userSettingVarMap should not be null", deserialized.userSettingVarMap)
        assertEquals("userSettingVarMap size mismatch", jsonMap.size, deserialized.userSettingVarMap!!.size)

        jsonMap.forEach { (key, settingJson) ->
            val deserializedEntry = deserialized.userSettingVarMap!!.entries.find { it.key.toString() == key }
            assertNotNull("userSettingVarMap missing key: $key", deserializedEntry)
        }
        println("userSettingVarMap verified: ${jsonMap.size} settings with all nested properties")
    }

    // ==========================================
    // OPTIONAL NULLABLE PROPERTIES
    // ==========================================

    @Test
    fun `verify displayDateFormat matches JSON`() {
        val jsonValue = rootJson["displayDateFormat"]
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("displayDateFormat should be null", null, deserialized.displayDateFormat)
        } else {
            assertEquals(
                "displayDateFormat mismatch",
                jsonValue.jsonPrimitive.content,
                deserialized.displayDateFormat
            )
        }
        println("displayDateFormat verified")
    }

    @Test
    fun `verify grandManagerId matches JSON`() {
        val jsonValue = rootJson["grandManagerId"]
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("grandManagerId should be null", null, deserialized.grandManagerId)
        } else {
            assertEquals(
                "grandManagerId mismatch",
                jsonValue.jsonPrimitive.content,
                deserialized.grandManagerId?.toString()
            )
        }
        println("grandManagerId verified")
    }

    @Test
    fun `verify languageKey matches JSON`() {
        val jsonValue = rootJson["languageKey"]
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("languageKey should be null", null, deserialized.languageKey)
        } else {
            assertEquals(
                "languageKey mismatch",
                jsonValue.jsonPrimitive.content,
                deserialized.languageKey?.toString()
            )
        }
        println("languageKey verified")
    }

    @Test
    fun `verify locationAccuracy matches JSON`() {
        val jsonValue = rootJson["locationAccuracy"]
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("locationAccuracy should be null", null, deserialized.locationAccuracy)
        } else {
            assertEquals(
                "locationAccuracy mismatch",
                jsonValue.jsonPrimitive.content,
                deserialized.locationAccuracy?.name
            )
        }
        println("locationAccuracy verified")
    }

    @Test
    fun `verify managerId matches JSON`() {
        val jsonValue = rootJson["managerId"]
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("managerId should be null", null, deserialized.managerId)
        } else {
            assertEquals(
                "managerId mismatch",
                jsonValue.jsonPrimitive.content,
                deserialized.managerId?.toString()
            )
        }
        println("managerId verified")
    }

    @Test
    fun `verify timeZone matches JSON`() {
        val jsonValue = rootJson["timeZone"]
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("timeZone should be null", null, deserialized.timeZone)
        } else {
            assertEquals(
                "timeZone mismatch",
                jsonValue.jsonPrimitive.content,
                deserialized.timeZone?.toString()
            )
        }
        println("timeZone verified")
    }

    // ==========================================
    // ROUNDTRIP SERIALIZATION TEST
    // ==========================================

    @Test
    fun `verify roundtrip serialization preserves all data`() {
        // Serialize and deserialize again
        val serializedJson = json.encodeToString(deserialized)
        val roundtrip = json.decodeFromString<SigEntCallerData>(serializedJson)

        // Compare key properties
        assertEquals("entId roundtrip mismatch", deserialized.entId, roundtrip.entId)
        assertEquals("entUserId roundtrip mismatch", deserialized.entUserId, roundtrip.entUserId)
        assertEquals("handle roundtrip mismatch", deserialized.handle, roundtrip.handle)
        assertEquals("nickName roundtrip mismatch", deserialized.nickName, roundtrip.nickName)
        assertEquals("actionMap size roundtrip mismatch", deserialized.actionMap.size, roundtrip.actionMap.size)
        assertEquals("formMap size roundtrip mismatch", deserialized.formMap.size, roundtrip.formMap.size)
        assertEquals("roleMap size roundtrip mismatch", deserialized.roleMap.size, roundtrip.roleMap.size)

        println("Roundtrip serialization verified - all data preserved")
    }

    // ==========================================
    // HELPER METHODS
    // ==========================================

    private fun assertJsonEquals(path: String, jsonValue: JsonElement?, actual: String) {
        assertNotNull("$path should exist in JSON", jsonValue)
        assertEquals(path, jsonValue!!.jsonPrimitive.content, actual)
    }

    private fun assertJsonEqualsNullable(path: String, jsonValue: JsonElement?, actual: String?) {
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("$path should be null", null, actual)
        } else {
            assertEquals(path, jsonValue.jsonPrimitive.contentOrNull, actual)
        }
    }

    private fun assertJsonEqualsBoolean(path: String, jsonValue: JsonElement?, actual: Boolean) {
        assertNotNull("$path should exist in JSON", jsonValue)
        assertEquals(path, jsonValue!!.jsonPrimitive.boolean, actual)
    }

    private fun assertJsonEqualsNullableBoolean(path: String, jsonValue: JsonElement?, actual: Boolean?) {
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("$path should be null", null, actual)
        } else {
            assertEquals(path, jsonValue.jsonPrimitive.booleanOrNull, actual)
        }
    }

    private fun assertJsonEqualsNullableLong(path: String, jsonValue: JsonElement?, actual: Long?) {
        if (jsonValue == null || jsonValue is JsonNull) {
            assertEquals("$path should be null", null, actual)
        } else {
            assertEquals(path, jsonValue.jsonPrimitive.longOrNull, actual)
        }
    }

    private fun verifyJsonArray(path: String, jsonValue: JsonElement?, actual: List<String>) {
        if (jsonValue == null || jsonValue is JsonNull) {
            assertTrue("$path should be empty", actual.isEmpty())
            return
        }

        val jsonArray = jsonValue.jsonArray
        assertEquals("$path size mismatch", jsonArray.size, actual.size)

        jsonArray.forEachIndexed { index, element ->
            assertEquals("$path[$index] mismatch", element.jsonPrimitive.content, actual[index])
        }
    }
}
