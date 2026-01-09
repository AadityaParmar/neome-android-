package com.neome.core.common.serializer.api.ent.agent.sig

import com.neome.api.ent.agent.sig.SigAgentEntUserList
import com.neome.api.ent.base.dto.DtoAgentEntUser
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigAgentEntUserListData(
    override val version: String,
    override val entUserMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, DtoAgentEntUser>
) : SigAgentEntUserList
