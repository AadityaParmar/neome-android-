package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioEntReportSpreadsheet
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntReportSpreadsheetData(
    override val details: StudioDetailsData,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    override val kind: EnumDefnKindReport,
    @Serializable(with = MetaIdReportSer::class) override val metaId: Types.MetaIdReport,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm? = null,
    override val ascOrder: Boolean? = null,
    override val filterConditionVarId: StudioValueVarIdConditionData? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val fromSpreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val limit: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val orderByFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val outputFormMappingVarId: Types.MetaIdVar? = null
) : StudioEntReportSpreadsheet
