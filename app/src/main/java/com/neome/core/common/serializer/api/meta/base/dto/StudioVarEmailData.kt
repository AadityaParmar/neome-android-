package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDeploy
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarEmail
import com.neome.api.meta.base.dto.StudioVarValueEmail
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioVarValueEmailData
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarEmailData(
    override val deploy: EnumDefnDeploy,
    override val details: StudioDetailsData,
    override val kind: EnumStudioVarKind,
    @Serializable(with = MetaIdVarSer::class) override val metaId: Types.MetaIdVar,
    override val value: StudioVarValueEmailData? = null
) : StudioVarEmail
