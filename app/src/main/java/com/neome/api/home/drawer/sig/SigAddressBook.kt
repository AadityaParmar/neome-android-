// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoUserAddrBookContact
import com.neome.api.home.base.dto.DtoUserAddrBookOtherContact
import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.SigVersion

class SigAddressBook : SigVersion() {
    val candidateMap: Record<AnyPrefixKey, DtoUserAddrBookContact[]>
    val othersList: DtoUserAddrBookOtherContact[]
}
