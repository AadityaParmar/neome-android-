package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDeploy
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarTimeZone
import com.neome.api.meta.base.dto.StudioVarValueTimeZone
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioVarValueTimeZoneData
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarTimeZoneData(
    override val deploy: EnumDefnDeploy,
    override val details: StudioDetailsData,
    override val kind: EnumStudioVarKind,
    @Serializable(with = MetaIdVarSer::class) override val metaId: Types.MetaIdVar,
    override val value: StudioVarValueTimeZoneData? = null
) : StudioVarTimeZone
