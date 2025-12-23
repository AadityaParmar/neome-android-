// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.studio.base.dto.DtoEntUser

open class SigEntUser : Sig() {
    lateinit var user: DtoEntUser
}
