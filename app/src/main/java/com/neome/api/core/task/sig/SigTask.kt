// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.task.sig

import com.neome.api.core.base.Types.EnumTaskStatus
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig

open class SigTask : Sig() {
    var error: EnvValidationError? = null
    var progress: Number? = null
    var result: Object? = null
    lateinit var status: EnumTaskStatus
}
