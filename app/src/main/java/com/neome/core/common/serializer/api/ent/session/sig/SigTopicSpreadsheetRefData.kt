package com.neome.core.common.serializer.api.ent.session.sig

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.core.session.sig.SigTopic
import com.neome.api.ent.session.sig.SigTopicSpreadsheetRef
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetRefSer
import com.neome.core.common.serializer.sysId.RowIdSer
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigTopicSpreadsheetRefData(
    @Serializable(with = SysIdSer::class) override val aboutId: SysId,
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val type: EnumTopicType,
    @Serializable(with = MetaIdSpreadsheetRefSer::class) override val metaIdSpreadsheetRef: Types.MetaIdSpreadsheetRef,
    @Serializable(with = RowIdSer::class) override val targetRowId: Types.RowId
) : SigTopicSpreadsheetRef
