// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig

class SigMessageBulk : Sig() {
    val errorMap: Record<number, EnvValidationError>
    val messageMap: Record<number, SigMessage>
}
