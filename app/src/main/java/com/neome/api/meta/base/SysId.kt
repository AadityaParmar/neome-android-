// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base

import kotlin.reflect.KClass

/**
 * Abstract base class for system identifiers with type-safe prefix handling
 */
abstract class SysId : Comparable<SysId> {

    private var id: String? = null

    companion object {
        const val GLOBAL = "global" // global ent Id
        const val SEP_PREFIX = "-"
        const val SEP_EXT = "."

        private val systemIdMap = mutableMapOf<String, SysId>()

        init {
            // Initialize system IDs for roles
            Types.EnumDefnRoles.entries.forEach { value ->
                val sysId =
                        createInternal<Types.MetaIdRole>(value.name, Types.MetaIdRole::class.java)
                systemIdMap[value.name] = sysId
            }

            // Initialize system IDs for fields
            Types.EnumDefnFields.entries.forEach { value ->
                val sysId =
                        createInternal<Types.MetaIdField>(value.name, Types.MetaIdField::class.java)
                systemIdMap[value.name] = sysId
            }

            // Initialize system IDs for forms
            Types.EnumDefnForms.entries.forEach { value ->
                val sysId =
                        createInternal<Types.MetaIdForm>(value.name, Types.MetaIdForm::class.java)
                systemIdMap[value.name] = sysId
            }

            // Initialize system IDs for pipeline system
            Types.EnumDefnPipelineSystem.entries.forEach { value ->
                val sysId = createInternal<Types.MetaIdPipelineSystem>(
                        value.name,
                        Types.MetaIdPipelineSystem::class.java
                )
                systemIdMap[value.name] = sysId
            }
        }

        /**
         * Creates a SysId from a string ID
         * @param id The string identifier
         * @return The typed SysId or null if id is null
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : SysId> create(id: String?): T? {
            if (id == null) {
                return null
            }

            if (GLOBAL == id) {
                return createInternal<T>(id, Types.EntId::class.java)
            }

            val systemSysId = systemIdMap[id]
            if (systemSysId != null) {
                return systemSysId as T
            }

            if (id.isEmpty()) {
                throw IllegalArgumentException("Invalid sys id: $id - must not be empty")
            }
            if (id.contains(" ") || id.contains("\t") || id.contains("\n")) {
                throw IllegalArgumentException("Invalid sys id: $id - must not contain whitespaces")
            }
            if (!id.contains(SEP_PREFIX)) {
                throw IllegalArgumentException("Invalid sys id: $id - must contain separator")
            }
            if (!id.matches(Regex("^[a-zA-Z0-9._-]*$"))) {
                throw IllegalArgumentException("Invalid sys id: $id - contains invalid characters")
            }

            var modifiedId = id
            val prefix = id.split(SEP_PREFIX, limit = 2)[0]
            if (prefix.isEmpty()) {
                throw IllegalArgumentException("Prefix must not be empty")
            }

            val clsSysId = Types.getSysIdClass(prefix)
                    ?: throw IllegalArgumentException("Prefix not supported: $prefix")

            val newPrefix = Types.getSysIdPrefix(clsSysId)
            if (newPrefix != null && prefix != newPrefix) {
                modifiedId = id.replaceFirst(prefix, newPrefix)
            }

            return createInternal<T>(modifiedId, clsSysId)
        }

        /**
         * Creates array of SysId from array of string IDs
         */
        fun create(ids: Array<String>?): Array<SysId?>? {
            if (ids == null) {
                return null
            }

            return Array(ids.size) { i -> create<SysId>(ids[i]) }
        }

        /**
         * Generates next ID for the given SysId class
         */
        fun <T : SysId> nextId(clsSysId: Class<T>): T {
            return nextId(clsSysId, null)
        }

        /**
         * Generates next ID for the given SysId class with optional extension
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : SysId> nextId(clsSysId: Class<T>, ext: String?): T {
            val guid = when {
                clsSysId == Types.RequestId::class.java || clsSysId == Types.RowId::class.java -> {
                    NanoId.newGuidBig()
                }

                Types.MetaId::class.java.isAssignableFrom(clsSysId) -> {
                    NanoId.newMetaId()
                }

                else -> {
                    NanoId.newGuid()
                }
            }

            return nextId(clsSysId, guid, ext)
        }

        /**
         * Generates next ID for the given SysId class with GUID and extension
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : SysId> nextId(clsSysId: Class<T>?, guid: String?, ext: String?): T {
            requireNotNull(clsSysId) { "clsSysId must not be null" }
            requireNotNull(guid) { "guid must not be null" }

            val prefix = Types.getSysIdPrefix(clsSysId)
                    ?: throw IllegalArgumentException("prefix must not be null")

            val id = if (ext != null) {
                prefix + SEP_PREFIX + guid + SEP_EXT + ext
            } else {
                prefix + SEP_PREFIX + guid
            }

            return createInternal<T>(id, clsSysId)
        }

        /**
         * Converts SysId to string
         */
        fun toString(id: SysId?): String? {
            return id?.getId()
        }

        /**
         * Creates SysId instance from ID and class (internal helper)
         */
        @Suppress("UNCHECKED_CAST")
        private fun <T : SysId> createInternal(id: String?, clsSysId: Class<out SysId>?): T {
            requireNotNull(clsSysId) { "clsSysId must not be null" }

            if (id == null) {
                return null as T
            }

            return try {
                val sysId = clsSysId.getDeclaredConstructor().newInstance()
                sysId.id = id
                sysId as T
            } catch (e: Exception) {
                throw AssertionError(e)
            }
        }

        /**
         * Checks if the SysId is a system ID
         */
        fun isSystemId(sysId: SysId): Boolean {
            return systemIdMap.containsKey(sysId.getId())
        }
    }

    /**
     * Checks if this SysId is a system ID
     */
    fun isSystem(): Boolean {
        return systemIdMap.containsValue(this)
    }

    override fun compareTo(other: SysId): Int {
        return (id ?: "").compareTo(other.getId() ?: "")
    }

    override fun equals(other: Any?): Boolean {
        return other is SysId && id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return id ?: ""
    }

    /**
     * Gets the extension part of the ID (after the dot)
     */
    fun getExt(): String? {
        val currentId = id ?: return null
        val index = currentId.indexOf(SEP_EXT)
        return if (index < 0) null else currentId.substring(index + 1)
    }

    /**
     * Gets the full ID string
     */
    fun getId(): String? {
        return id
    }

    /**
     * Gets the ID without the prefix
     */
    fun getIdWithoutPrefix(): String? {
        if (isSystem()) {
            return getId()
        }
        val currentId = id ?: return null
        val prefix = getPrefix() ?: return currentId
        return currentId.substring(prefix.length + SEP_PREFIX.length)
    }

    /**
     * Gets the prefix part of the ID
     */
    fun getPrefix(): String? {
        @Suppress("UNCHECKED_CAST")
        return Types.getSysIdPrefix(javaClass as Class<out SysId>)
    }

    /**
     * Gets the suffix part of the ID (after the prefix separator)
     */
    fun getSuffix(): String? {
        val currentId = id ?: return null
        val index = currentId.indexOf(SEP_PREFIX)
        return if (index < 0) currentId else currentId.substring(index + 1)
    }

    /**
     * Checks if this SysId is of the given class type
     */
    fun `is`(sysIdClass: Class<out SysId>): Boolean {
        return sysIdClass.isAssignableFrom(javaClass)
    }

    /**
     * Checks if this SysId is of the given Kotlin class type
     */
    fun `is`(sysIdClass: KClass<out SysId>): Boolean {
        return sysIdClass.java.isAssignableFrom(javaClass)
    }
}
