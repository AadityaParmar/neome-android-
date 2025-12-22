// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base

// SysId implementation placeholder
// This is a simplified version - full implementation should match Java version

abstract class SysId : Comparable<SysId> {
    companion object {
        const val GLOBAL = "global"
        const val SEP_PREFIX = "-"
        const val SEP_EXT = "."

        fun <T : SysId> create(id: String?): T? {
            // Simplified implementation - should match Java version
            TODO("SysId.create() not yet implemented for Kotlin")
        }

        fun <T : SysId> nextId(clsSysId: Class<T>): T {
            TODO("SysId.nextId() not yet implemented for Kotlin")
        }
    }

    protected var id: String = ""

    fun getId(): String = id

    override fun compareTo(other: SysId): Int = id.compareTo(other.id)

    override fun equals(other: Any?): Boolean = other is SysId && id == other.id

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String = id
}
