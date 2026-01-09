package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.core.base.dto.DtoTopic
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoTopicData(
    @Serializable(with = SysIdSer::class) override val aboutId: SysId,
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val type: EnumTopicType
) : DtoTopic
