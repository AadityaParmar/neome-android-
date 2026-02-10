package com.neome.feature.form.domain.util

import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.meta.base.AnyEmailId
import com.neome.api.meta.base.AnyValue
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPermission
import com.neome.api.meta.base.Types.EnumDefnRoles
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnGrid
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.DefnTab
import com.neome.api.meta.base.dto.DefnWizard
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetDateData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetDateTimeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateRangeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateTimeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateTimeRangeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldEmailData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldHandleData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.TypeUiFormParentMap
import com.neome.feature.form.domain.TypeUiFormPermission
import com.neome.feature.form.domain.TypeUiFormPermissionMap
import com.neome.feature.form.domain.TypeUiManagerialRelationship
import com.neome.feature.form.domain.TypeUiPermissionRole
import com.neome.feature.form.domain.util.FilterForm.matchAllRoles
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject

/**
 * Utility for preparing a DefnForm for UI consumption.
 *
 * This transforms a [DefnFormData] into a [DefnFormUi] by:
 * 1. Computing permission maps for all components based on caller's roles
 * 2. Building parent-child relationship maps
 * 3. Populating managerial relationship user sets
 * 4. Injecting caller-specific properties (timezone, handle, date format)
 *
 * Equivalent to TypeScript's FilterFormPlus.ts PrepareUiForm class.
 */
object FilterForm {

    private val defaultPermission: EnumDefnPermission = EnumDefnPermission.write

    private val permissionPriorityMap: Map<EnumDefnPermission, Int> = mapOf(
        EnumDefnPermission.write to 6,
        EnumDefnPermission.writeOnce to 5,
        EnumDefnPermission.writeOnInsert to 4,
        EnumDefnPermission.read to 3,
        EnumDefnPermission.invisible to 2,
        EnumDefnPermission.hide to 1
    )

    // region --- Foundation Helpers ---

    /**
     * Returns the permission with higher priority.
     * If [existingPermission] is null, returns [newPermission].
     */
    private fun getHigherPriorityPermission(
        existingPermission: EnumDefnPermission?,
        newPermission: EnumDefnPermission
    ): EnumDefnPermission {
        if (existingPermission == null) return newPermission

        val existingPriority = permissionPriorityMap[existingPermission] ?: 0
        val newPriority = permissionPriorityMap[newPermission] ?: 0

        return if (existingPriority > newPriority) existingPermission else newPermission
    }

    /**
     * Returns true if every role in [callerRoles] is present in [targetRoles].
     */
    private fun matchAllRoles(
        callerRoles: List<MetaIdRole>,
        targetRoles: List<MetaIdRole>
    ): Boolean {
        return callerRoles.all { it in targetRoles }
    }

    /**
     * Finds the [EnumDefnRoles] value whose string ID matches the given [MetaIdRole].
     */
    private fun enumDefnRolesFromId(roleId: MetaIdRole): EnumDefnRoles? {
        val idStr = roleId.getId() ?: return null
        return EnumDefnRoles.entries.find { it.value == idStr }
    }

    /**
     * Extracts the [MetaIdComp] from a [DefnCompSeal].
     * Different component types have different metaId types (MetaIdField, MetaIdSection, etc.)
     * but they all extend MetaIdComp.
     */
    private fun getCompMetaId(comp: DefnCompSeal): MetaIdComp? {
        return (comp as? DefnField)?.metaId
            ?: (comp as? DefnSection)?.metaId
            ?: (comp as? DefnGrid)?.metaId
            ?: (comp as? DefnTab)?.metaId
            ?: (comp as? DefnWizard)?.metaId
    }

    // endregion

    // region --- Permission Resolution ---

    /**
     * Resolves the effective permission for a component based on the caller's roles,
     * the component's permission matrix, and optionally the parent's resolved permission.
     *
     * For each caller role, looks up the permission in the matrix and keeps the highest
     * priority one. Falls back to the matrix's default permission, then to the parent's
     * Caller permission. Also resolves permissions for system roles ($Manager, $Public, etc.).
     *
     * TS Reference: FilterFormPlus.ts lines 182-227
     */
    private fun getPermission(
        roleIdSet: List<MetaIdRole>,
        permissionMatrix: DefnDtoPermissionMatrix?,
        parentPermission: MutableMap<TypeUiPermissionRole, EnumDefnPermission>? = null
    ): MutableMap<TypeUiPermissionRole, EnumDefnPermission> {
        val roleToPermissionMap = mutableMapOf<TypeUiPermissionRole, EnumDefnPermission>()

        // 1. Resolve caller permission from their role set
        for (roleId in roleIdSet) {
            val permission = permissionMatrix?.map?.get(roleId)
            if (permission != null) {
                roleToPermissionMap[TypeUiPermissionRole.Caller] =
                    getHigherPriorityPermission(
                        roleToPermissionMap[TypeUiPermissionRole.Caller],
                        permission
                    )
            } else if (permissionMatrix?.defaultPermission != null) {
                roleToPermissionMap[TypeUiPermissionRole.Caller] =
                    getHigherPriorityPermission(
                        roleToPermissionMap[TypeUiPermissionRole.Caller],
                        permissionMatrix.defaultPermission!!
                    )
            }
        }

        // 2. Inherit parent's Caller permission if not resolved
        if (parentPermission != null && roleToPermissionMap[TypeUiPermissionRole.Caller] == null) {
            parentPermission[TypeUiPermissionRole.Caller]?.let {
                roleToPermissionMap[TypeUiPermissionRole.Caller] = it
            }
        }

        // 3. Resolve system role permissions
        for (sysRole in EnumDefnRoles.entries) {
            val sysRoleId = SysId.create<MetaIdRole>(sysRole.value) ?: continue
            val permission = permissionMatrix?.map?.get(sysRoleId)

            if (permission != null) {
                val roleKey = TypeUiPermissionRole.Role(sysRole)
                roleToPermissionMap[roleKey] = getHigherPriorityPermission(
                    roleToPermissionMap[TypeUiPermissionRole.Caller],
                    permission
                )
            } else if (parentPermission != null) {
                val roleKey = TypeUiPermissionRole.Role(sysRole)
                parentPermission[roleKey]?.let {
                    roleToPermissionMap[roleKey] = it
                }
            }
        }

        return roleToPermissionMap
    }

    /**
     * Determines if a component should be disabled or required for the current caller.
     *
     * Splits role IDs into system roles (stored directly by role key) and regular roles
     * (checked via [matchAllRoles] and stored under Caller key).
     *
     * TS Reference: FilterFormPlus.ts lines 76-138
     */
    private fun getRequiredAndDisabledPermission(
        roleIdSet: List<MetaIdRole>,
        comp: DefnCompSeal
    ): Pair<Map<TypeUiPermissionRole, Boolean>?, Map<TypeUiPermissionRole, Boolean>?> {
        val disabledRoleIdSet = comp.disabledRoleIdSet
        val requiredRoleIdSet = (comp as? DefnFieldEditable)?.requiredRoleIdSet

        var disabled: MutableMap<TypeUiPermissionRole, Boolean>? = null
        var required: MutableMap<TypeUiPermissionRole, Boolean>? = null

        if (disabledRoleIdSet != null) {
            val filteredDisabledRoleIdSet = mutableListOf<MetaIdRole>()
            for (roleId in disabledRoleIdSet) {
                if (SysId.isSystemId(roleId)) {
                    val sysRole = enumDefnRolesFromId(roleId)
                    if (sysRole != null) {
                        if (disabled == null) disabled = mutableMapOf()
                        disabled[TypeUiPermissionRole.Role(sysRole)] = true
                    }
                } else {
                    filteredDisabledRoleIdSet.add(roleId)
                }
            }
            if (filteredDisabledRoleIdSet.isNotEmpty()
                && matchAllRoles(roleIdSet, filteredDisabledRoleIdSet)
            ) {
                if (disabled == null) disabled = mutableMapOf()
                disabled[TypeUiPermissionRole.Caller] = true
            }
        }

        if (requiredRoleIdSet != null) {
            val filteredRequiredRoleIdSet = mutableListOf<MetaIdRole>()
            for (roleId in requiredRoleIdSet) {
                if (SysId.isSystemId(roleId)) {
                    val sysRole = enumDefnRolesFromId(roleId)
                    if (sysRole != null) {
                        if (required == null) required = mutableMapOf()
                        required[TypeUiPermissionRole.Role(sysRole)] = true
                    }
                } else {
                    filteredRequiredRoleIdSet.add(roleId)
                }
            }
            if (filteredRequiredRoleIdSet.isNotEmpty()
                && matchAllRoles(roleIdSet, filteredRequiredRoleIdSet)
            ) {
                if (required == null) required = mutableMapOf()
                required[TypeUiPermissionRole.Caller] = true
            }
        }

        return Pair(disabled, required)
    }

    // endregion

    // region --- Property Injection ---

    /**
     * Injects caller-specific properties into field definitions.
     *
     * - For email/handle fields with autoPickSelf: sets defaultValue to caller's handle
     * - For date-family fields: sets timeZone from caller and displayDateFormat if not already set
     *
     * Returns the modified component (via `.copy()`) if changes were made, or null if unchanged.
     *
     * TS Reference: FilterFormPlus.ts lines 140-180
     */
    private fun insertDefnProperties(
        comp: DefnCompSeal,
        callerEnt: SigEntCaller
    ): DefnCompSeal? {
        return when (comp) {
            is DefnFieldEmailData -> {
                if (comp.autoPickSelf == true) {
                    val emailId = AnyValue.create(callerEnt.handle, AnyEmailId::class.java)
                    comp.copy(defaultValue = emailId)
                } else null
            }

            is DefnFieldHandleData -> {
                if (comp.autoPickSelf == true) comp.copy(defaultValue = callerEnt.handle)
                else null
            }

            is DefnFieldDateData -> comp.copy(
                timeZone = callerEnt.timeZone,
                displayDateFormat = comp.displayDateFormat ?: callerEnt.displayDateFormat
            )

            is DefnFieldDateTimeData -> comp.copy(
                timeZone = callerEnt.timeZone,
                displayDateFormat = comp.displayDateFormat ?: callerEnt.displayDateFormat
            )

            is DefnFieldDateRangeData -> comp.copy(
                timeZone = callerEnt.timeZone,
                displayDateFormat = comp.displayDateFormat ?: callerEnt.displayDateFormat
            )

            is DefnFieldDateTimeRangeData -> comp.copy(
                timeZone = callerEnt.timeZone,
                displayDateFormat = comp.displayDateFormat ?: callerEnt.displayDateFormat
            )

            is DefnFieldChipSetDateData -> comp.copy(
                timeZone = callerEnt.timeZone,
                displayDateFormat = comp.displayDateFormat ?: callerEnt.displayDateFormat
            )

            is DefnFieldChipSetDateTimeData -> comp.copy(
                timeZone = callerEnt.timeZone,
                displayDateFormat = comp.displayDateFormat ?: callerEnt.displayDateFormat
            )

            else -> null
        }
    }

    // endregion

    // region --- Post-Processing ---

    /**
     * Optimizes the permission map by collapsing redundant entries:
     * - If Caller has "write" permission, discard all other role permissions
     * - If all roles have the same permission, collapse to just Caller = that permission
     *
     * TS Reference: FilterFormPlus.ts lines 229-268
     */
    private fun trimPermissionMap(
        permissionMap: MutableMap<MetaIdComp, TypeUiFormPermission>
    ) {
        for ((metaId, formPermission) in permissionMap) {
            val permissions = formPermission.permission ?: continue

            // If caller can write, ignore other permissions
            if (permissions[TypeUiPermissionRole.Caller] == EnumDefnPermission.write) {
                permissionMap[metaId] = formPermission.copy(
                    permission = mapOf(TypeUiPermissionRole.Caller to EnumDefnPermission.write)
                )
                continue
            }

            // Check if all permissions are the same — if so, collapse to Caller
            val values = permissions.values.toList()
            if (values.isNotEmpty() && values.all { it == values[0] }) {
                permissionMap[metaId] = formPermission.copy(
                    permission = mapOf(TypeUiPermissionRole.Caller to values[0])
                )
            }
        }
    }

    /**
     * Ensures that if any child component is visible (not hide/invisible),
     * its parent chain is upgraded to at least "read" permission.
     *
     * Prevents the scenario where a visible field is inside a hidden section.
     *
     * TS Reference: FilterFormPlus.ts lines 283-333
     */
    private fun ensureParentVisibility(
        permissionMap: MutableMap<MetaIdComp, TypeUiFormPermission>,
        parentMap: Map<MetaIdComp, List<MetaIdComp>>
    ) {
        for ((metaId, formPermission) in permissionMap) {
            val permissions = formPermission.permission ?: continue

            // Check if this component is visible
            val isVisible = permissions.values.any { permission ->
                permission != EnumDefnPermission.hide && permission != EnumDefnPermission.invisible
            }
            if (!isVisible) continue

            // Walk up the parent chain and upgrade hidden/invisible parents to "read"
            var parentId = parentMap[metaId]?.firstOrNull()
            if (parentId == null || parentId == parentMap[parentId]?.firstOrNull()) continue

            while (true) {
                if (parentId == null || parentId == parentMap[parentId]?.firstOrNull()) break

                val parentFormPermission = permissionMap[parentId] ?: break
                val parentPermissions = parentFormPermission.permission ?: break

                val updatedPermissions = parentPermissions.toMutableMap()
                var modified = false
                for ((key, permissionEnum) in parentPermissions) {
                    if (permissionEnum == EnumDefnPermission.hide
                        || permissionEnum == EnumDefnPermission.invisible
                    ) {
                        updatedPermissions[key] = EnumDefnPermission.read
                        modified = true
                    }
                }
                if (modified) {
                    permissionMap[parentId] =
                        parentFormPermission.copy(permission = updatedPermissions)
                }

                parentId = parentMap[parentId]?.firstOrNull()
            }
        }
    }

    // endregion

    // region --- Managerial Relationships ---

    /**
     * Populates the managerial relationship map when permission entries reference
     * system roles like $Manager, $GrandManager, $AllManagers, $Assistants, $AllAssistants.
     *
     * Extracts the corresponding user ID sets from the caller's managerialRelationshipMap.
     *
     * TS Reference: FilterFormPlus.ts lines 335-391
     */
    private fun insertManagerialRelationship(
        callerEnt: SigEntCaller,
        permission: Map<TypeUiPermissionRole, EnumDefnPermission>,
        managerialRelationship: MutableManagerialRelationship
    ) {
        if (permission.containsKey(TypeUiPermissionRole.Role(EnumDefnRoles.Manager))) {
            insertManagerialRelationshipUsers(
                EnumDefnRoles.Manager, callerEnt, managerialRelationship
            )
        }
        if (permission.containsKey(TypeUiPermissionRole.Role(EnumDefnRoles.GrandManager))) {
            insertManagerialRelationshipUsers(
                EnumDefnRoles.GrandManager, callerEnt, managerialRelationship
            )
        }
        if (permission.containsKey(TypeUiPermissionRole.Role(EnumDefnRoles.AllManagers))) {
            insertManagerialRelationshipUsers(
                EnumDefnRoles.AllManagers, callerEnt, managerialRelationship
            )
        }
        if (permission.containsKey(TypeUiPermissionRole.Role(EnumDefnRoles.Assistants))) {
            insertManagerialRelationshipUsers(
                EnumDefnRoles.Assistants, callerEnt, managerialRelationship
            )
        }
        if (permission.containsKey(TypeUiPermissionRole.Role(EnumDefnRoles.AllAssistants))) {
            insertManagerialRelationshipUsers(
                EnumDefnRoles.AllAssistants, callerEnt, managerialRelationship
            )
        }
    }

    /**
     * Extracts user ID set for a specific managerial role from callerEnt
     * and stores it in the mutable relationship map (if not already set).
     */
    private fun insertManagerialRelationshipUsers(
        role: EnumDefnRoles,
        callerEnt: SigEntCaller,
        managerialRelationship: MutableManagerialRelationship
    ) {
        val roleId = SysId.create<MetaIdRole>(role.value) ?: return
        val userSet = callerEnt.managerialRelationshipMap?.get(roleId) ?: return
        val userIdSet = userSet.toSet()

        when (role) {
            EnumDefnRoles.Manager -> {
                if (managerialRelationship.manager == null) {
                    managerialRelationship.manager = userIdSet
                }
            }

            EnumDefnRoles.GrandManager -> {
                if (managerialRelationship.grandManager == null) {
                    managerialRelationship.grandManager = userIdSet
                }
            }

            EnumDefnRoles.AllManagers -> {
                if (managerialRelationship.allManagers == null) {
                    managerialRelationship.allManagers = userIdSet
                }
            }

            EnumDefnRoles.Assistants -> {
                if (managerialRelationship.assistants == null) {
                    managerialRelationship.assistants = userIdSet
                }
            }

            EnumDefnRoles.AllAssistants -> {
                if (managerialRelationship.allAssistants == null) {
                    managerialRelationship.allAssistants = userIdSet
                }
            }

            else -> { /* $Public, $Self — no managerial relationship */
            }
        }
    }

    // endregion

    // region --- Orchestration ---

    /**
     * Prepares a [DefnFormData] for UI consumption by resolving permissions,
     * building parent maps, and injecting caller-specific properties.
     *
     * @param form The raw form definition from the server.
     * @param callerEnt The current user's context (roles, handle, timezone, etc.).
     * @return A [DefnFormUi] enriched with permission maps, parent maps, and managerial relationships.
     *
     * TS Reference: FilterFormPlus.ts lines 393-457
     */
    fun prepare(form: DefnFormData, callerEnt: SigEntCaller): DefnFormUi {
        val roleIdSet = callerEnt.roleIdSet
        val mutableCompMap = form.compMap.toMutableMap()
        val formJson = JsonParser.json.encodeToJsonElement(DefnFormData.serializer(), form)
        val parentMap = mutableMapOf<MetaIdComp, MutableList<MetaIdComp>>()
        val managerialRelationship = MutableManagerialRelationship()
        val permissionResolveMap = mutableMapOf<MetaIdComp, TypeUiFormPermission>()

        // 1. Ensure form has a default permission
        val formPermissionMatrix: DefnDtoPermissionMatrix =
            if (form.permissionMatrix?.defaultPermission == null) {
                DefnDtoPermissionMatrixData(
                    defaultPermission = defaultPermission,
                    keys = form.permissionMatrix?.keys,
                    map = form.permissionMatrix?.map
                )
            } else {
                form.permissionMatrix!!
            }

        // 2. Resolve form-level permission
        val formPermission = getPermission(roleIdSet, formPermissionMatrix)
        val formLevelPermission = TypeUiFormPermission(permission = formPermission)

        // 3. Walk the component tree
        // Note: Kotlin loopDefnForm callback is (comp, parent), TS is (parent, comp)
        FormPlus.loopDefnForm(form) { comp, parent ->
            val compId = getCompMetaId(comp) ?: return@loopDefnForm null
            val parentCompId = getCompMetaId(parent)

            // 3a. Build parent map
            if (parentCompId != null) {
                parentMap.getOrPut(compId) { mutableListOf() }.add(parentCompId)
            }

            // 3b. Inject caller-specific properties (may modify compMap)
            val modifiedComp = insertDefnProperties(comp, callerEnt)
            if (modifiedComp != null) {
                mutableCompMap[compId] = modifiedComp
            }

            // 3c. Resolve parent permission if not yet done
            if (parentCompId != null && !permissionResolveMap.containsKey(parentCompId)) {
                permissionResolveMap[parentCompId] = TypeUiFormPermission(
                    permission = getPermission(
                        roleIdSet,
                        parent.permissionMatrix,
                        formPermission
                    )
                )
            }

            // 3d. Compute disabled/required state
            val (disabled, required) = getRequiredAndDisabledPermission(roleIdSet, comp)

            // 3e. Resolve component permission (inherit from parent or form)
            val parentResolved: MutableMap<TypeUiPermissionRole, EnumDefnPermission>? =
                if (parentCompId != null) {
                    permissionResolveMap[parentCompId]?.permission?.toMutableMap()
                } else {
                    null
                } ?: formLevelPermission.permission?.toMutableMap()

            val permission = getPermission(roleIdSet, comp.permissionMatrix, parentResolved)

            // 3f. Populate managerial relationship users
            insertManagerialRelationship(callerEnt, permission, managerialRelationship)

            // 3g. Store resolved permission
            permissionResolveMap[compId] = TypeUiFormPermission(
                permission = permission,
                disabled = disabled,
                required = required
            )

            null // continue iteration
        }

        // 4. Post-processing
        ensureParentVisibility(permissionResolveMap, parentMap)
        trimPermissionMap(permissionResolveMap)


        // 5. Construct DefnFormUi with all original form fields + computed maps

        val permissionResolveMapJsonObj = JsonParser.json.encodeToJsonElement(
            TypeUiFormPermissionMap.serializer(),
            TypeUiFormPermissionMap(permissionResolveMap)
        ).jsonObject

        val parentMapJsonObj = JsonParser.json.encodeToJsonElement(
            TypeUiFormParentMap.serializer(),
            TypeUiFormParentMap(parentMap)
        ).jsonObject
        val managerialRelationshipJsonObject = JsonParser.json.encodeToJsonElement(
            TypeUiManagerialRelationship.serializer(),
            managerialRelationship.toImmutable()
        ).jsonObject

        val mutableCompMapJsonObj = buildJsonObject {
            mutableCompMap.forEach { (key, value) ->
                put(
                    key.toString(),
                    JsonParser.json.encodeToJsonElement(DefnCompSeal.serializer(), value)
                )
            }
        }


        val defnFormUiJson: JsonElement = buildJsonObject {
            formJson.jsonObject.forEach { (key, value) -> put(key, value) }
            put("compMap", mutableCompMapJsonObj)
            put("_permissionMap", permissionResolveMapJsonObj)
            put("_parentMap", parentMapJsonObj)
            put("_managerialRelationship", managerialRelationshipJsonObject)
        }


        val defnFormUi = JsonParser.json.decodeFromJsonElement(DefnFormUi.serializer(), defnFormUiJson)
        println("===defnFormUiJson $defnFormUi ")
        return defnFormUi
    }

    // endregion

    /**
     * Mutable builder for [TypeUiManagerialRelationship].
     * Used during the prepare phase, then converted to the immutable data class.
     */
    private class MutableManagerialRelationship {
        var manager: Set<Types.EntUserId>? = null
        var grandManager: Set<Types.EntUserId>? = null
        var allManagers: Set<Types.EntUserId>? = null
        var assistants: Set<Types.EntUserId>? = null
        var allAssistants: Set<Types.EntUserId>? = null

        fun toImmutable(): TypeUiManagerialRelationship = TypeUiManagerialRelationship(
            manager = manager,
            grandManager = grandManager,
            allManagers = allManagers,
            assistants = assistants,
            allAssistants = allAssistants
        )
    }
}
