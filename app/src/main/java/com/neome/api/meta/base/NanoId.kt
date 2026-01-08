// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base

// NanoId implementation placeholder
import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import java.security.SecureRandom
import java.util.Random

open class NanoId : AnyValue()
{
    companion object
    {
        private val ALPHA_NUMERIC_CHARS: CharArray =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray()

        private val random: Random = SecureRandom()

        fun newGuid(): String
        {
            return NanoIdUtils.randomNanoId(random, ALPHA_NUMERIC_CHARS, 25)
        }

        fun newGuidBig(): String
        {
            return NanoIdUtils.randomNanoId(random, ALPHA_NUMERIC_CHARS, 32)
        }

        fun newMetaId(): String
        {
            return NanoIdUtils.randomNanoId(random, ALPHA_NUMERIC_CHARS, 10)
        }
    }
}