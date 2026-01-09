package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioEntReportMapper
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntReportMapperData(
    override val details: StudioDetails,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    override val kind: EnumDefnKindReport,
    @Serializable(with = MetaIdReportSer::class) override val metaId: Types.MetaIdReport,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdVarSer::class) override val inputFormMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdReportSer::class) override val mappedReportId: Types.MetaIdReport? = null,
    @Serializable(with = MetaIdVarSer::class) override val outputFormMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val saveToSpreadsheetId: Types.MetaIdSpreadsheet? = null
) : StudioEntReportMapper
