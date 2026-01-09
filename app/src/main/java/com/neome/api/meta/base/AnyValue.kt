// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base

// AnyValue base class placeholder

abstract class AnyValue : Comparable<AnyValue?> {
    var value: String? = null

    companion object {
        /**
         * Creates an AnyValue from a string value
         * @param id The string value
         * @param clsAnyValue The class type to create
         * @return The typed AnyValue or null if id is null
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : AnyValue> create(id: String?, clsAnyValue: Class<T>): T? {
            if (id == null) {
                return null
            }

            return try {
                val instance = clsAnyValue.getDeclaredConstructor().newInstance()
                instance.value = id
                instance as T
            } catch (e: Exception) {
                throw AssertionError(e)
            }
        }
    }

    override fun hashCode(): Int {
        return if (value == null)
            0
        else
            value.hashCode()
    }

    override fun toString(): String {
        return value!!
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }

        if (o == null || javaClass != o.javaClass) {
            return false
        }

        val that = o as AnyValue
        if (value == null) {
            return that.value == null
        } else if (that.value == null) {
            return false
        } else {
            return value == that.value
        }
    }

    override fun compareTo(other: AnyValue?): Int {
        return value!!.compareTo(other?.value!!)
    }


}
