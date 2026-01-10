package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoUserAddrBookContact
import com.neome.api.home.base.dto.DtoUserAddrBookOtherContact
import com.neome.api.home.drawer.sig.SigAddressBook
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.home.base.dto.DtoUserAddrBookContactData
import com.neome.core.common.serializer.api.home.base.dto.DtoUserAddrBookOtherContactData
import com.neome.core.common.serializer.sysId.AnyPrefixKeySer
import kotlinx.serialization.Serializable


@Serializable
data class SigAddressBookData(
    override val version: String,
    override val candidateMap: Map<@Serializable(with = AnyPrefixKeySer::class) com.neome.api.nucleus.base.Types.AnyPrefixKey, List<DtoUserAddrBookContactData>>,
    override val othersList: List<DtoUserAddrBookOtherContactData>
) : SigAddressBook
