// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.ent.base.dto.DtoPickerEntUser
import com.neome.api.nucleus.base.sig.Sig

open class SigEntUserPickerCandidateListGet : Sig() {
    lateinit var candidateList: Array<DtoPickerEntUser>
}
