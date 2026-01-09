package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDeploy
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarBoolean
import com.neome.api.meta.base.dto.StudioVarValueBoolean
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarBooleanData(
    override val deploy: EnumDefnDeploy,
    override val details: StudioDetails,
    override val kind: EnumStudioVarKind,
    @Serializable(with = MetaIdVarSer::class) override val metaId: Types.MetaIdVar,
    override val value: StudioVarValueBoolean? = null
) : StudioVarBoolean
