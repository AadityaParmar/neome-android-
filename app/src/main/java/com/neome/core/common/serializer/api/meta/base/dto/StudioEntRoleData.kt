package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntRole
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntRoleData(
    override val details: StudioDetailsData,
    @Serializable(with = MetaIdRoleSer::class) override val metaId: Types.MetaIdRole
) : StudioEntRole
