package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoUserAddrBookOtherContact
import kotlinx.serialization.Serializable


@Serializable
data class DtoUserAddrBookOtherContactData(
    override val handle: String,
    override val nickName: String
) : DtoUserAddrBookOtherContact
