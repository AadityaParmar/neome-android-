// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.home.base.dto.DtoUserAddrBookContact
import com.neome.api.home.base.dto.DtoUserAddrBookOtherContact
import com.neome.api.nucleus.base.sig.SigVersion

interface SigAddressBook : SigVersion
{
  val candidateMap: Map<AnyPrefixKey, Array<DtoUserAddrBookContact>>
  val othersList: Array<DtoUserAddrBookOtherContact>
}