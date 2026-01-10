package com.neome.core.common.serializer.api.ent.agent.sig

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.core.session.sig.SigTopic
import com.neome.api.ent.agent.sig.SigTopicPluginApiRequest
import com.neome.api.ent.base.dto.DtoPluginApiRequestPayload
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.ent.base.dto.DtoPluginApiRequestPayloadData
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigTopicPluginApiRequestData(
    @Serializable(with = SysIdSer::class) override val aboutId: SysId,
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val type: EnumTopicType,
    override val payload: DtoPluginApiRequestPayloadData
) : SigTopicPluginApiRequest
