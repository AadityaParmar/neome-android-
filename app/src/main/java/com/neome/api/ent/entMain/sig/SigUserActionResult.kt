// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoEntUserInfo
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigUserActionResult : Sig() {
    lateinit var userMap: Map<EntUserId, DtoEntUserInfo>
}
