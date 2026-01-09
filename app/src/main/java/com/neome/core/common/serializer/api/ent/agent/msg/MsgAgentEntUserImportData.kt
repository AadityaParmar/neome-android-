package com.neome.core.common.serializer.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgAgentEntUserImport
import com.neome.api.ent.base.dto.DtoAgentEntUserImport
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgAgentEntUserImportData(
    override val ignoreManager: Boolean? = null,
    override val ignoreUserSettings: Boolean? = null,
    override val users: Array<DtoAgentEntUserImport>
) : MsgAgentEntUserImport
