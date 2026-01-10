package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleSelectionData
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationData(
    override val active: Boolean? = null,
    override val description: String? = null,
    override val kind: EnumDefnKindAutomation,
    @Serializable(with = MetaIdAutomationSer::class) override val metaId: Types.MetaIdAutomation,
    override val modules: StudioModuleSelectionData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val secondary: String? = null
) : StudioEntAutomation
