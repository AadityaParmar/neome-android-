// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigMessageBulk : Sig() {
    lateinit var errorMap: Map<Number, EnvValidationError>
    lateinit var messageMap: Map<Number, SigMessage>
}
