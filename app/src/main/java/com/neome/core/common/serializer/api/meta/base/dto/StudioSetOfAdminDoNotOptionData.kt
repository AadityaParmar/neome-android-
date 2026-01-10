package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfAdminDoNotOption
import kotlinx.serialization.Serializable


@Serializable
data class StudioSetOfAdminDoNotOptionData(
    override val valueSet: List<EnumDefnAdminDoNotOptionEnt>
) : StudioSetOfAdminDoNotOption
