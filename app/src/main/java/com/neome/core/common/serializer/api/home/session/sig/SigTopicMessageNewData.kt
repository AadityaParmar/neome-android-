package com.neome.core.common.serializer.api.home.session.sig

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.core.session.sig.SigTopic
import com.neome.api.home.session.sig.SigTopicMessageNew
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigTopicMessageNewData(
    @Serializable(with = SysIdSer::class) override val aboutId: SysId,
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val type: EnumTopicType,
    override val messageOffset: Long
) : SigTopicMessageNew
