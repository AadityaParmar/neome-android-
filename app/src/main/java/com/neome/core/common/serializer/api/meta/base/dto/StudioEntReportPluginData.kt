package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioEntReportPlugin
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPluginApiData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntReportPluginData(
    override val details: StudioDetailsData,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    override val kind: EnumDefnKindReport,
    @Serializable(with = MetaIdReportSer::class) override val metaId: Types.MetaIdReport,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdVarSer::class) override val inputFormMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val outputFormMappingVarId: Types.MetaIdVar? = null,
    override val pluginApi: StudioDtoPluginApiData? = null
) : StudioEntReportPlugin
