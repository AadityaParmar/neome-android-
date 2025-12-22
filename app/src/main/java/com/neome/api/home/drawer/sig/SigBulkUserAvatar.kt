// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig

class SigBulkUserAvatar : Sig() {
    var errorMap: Record<EntUserId, EnvValidationError>? = null
    var resultMap: Record<EntUserId, SigUserAvatar>? = null
}
