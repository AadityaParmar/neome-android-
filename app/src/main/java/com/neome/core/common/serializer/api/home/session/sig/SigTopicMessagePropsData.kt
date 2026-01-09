package com.neome.core.common.serializer.api.home.session.sig

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.core.session.sig.SigTopic
import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.home.session.sig.SigTopicMessageProps
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigTopicMessagePropsData(
    @Serializable(with = SysIdSer::class) override val aboutId: SysId,
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val type: EnumTopicType,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val receiptStatus: EnumReceiptStatus
) : SigTopicMessageProps
