package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptReport
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptReportData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport? = null
) : DtoNeoScriptReport
