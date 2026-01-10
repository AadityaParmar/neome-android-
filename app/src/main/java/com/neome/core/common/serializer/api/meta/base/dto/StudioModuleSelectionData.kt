package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioModuleSelectionData(
    override val moduleIdSet: List<@Serializable(with = MetaIdModuleSer::class) Types.MetaIdModule>
) : StudioModuleSelection
