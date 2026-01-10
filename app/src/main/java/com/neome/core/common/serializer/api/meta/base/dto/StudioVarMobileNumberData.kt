package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDeploy
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarMobileNumber
import com.neome.api.meta.base.dto.StudioVarValueMobileNumber
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioVarValueMobileNumberData
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarMobileNumberData(
    override val deploy: EnumDefnDeploy,
    override val details: StudioDetailsData,
    override val kind: EnumStudioVarKind,
    @Serializable(with = MetaIdVarSer::class) override val metaId: Types.MetaIdVar,
    override val value: StudioVarValueMobileNumberData? = null
) : StudioVarMobileNumber
