package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationScheduled
import com.neome.api.meta.base.dto.StudioEntAutomationScheduledEventMap
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioVarValueScheduler
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationScheduledData(
    override val active: Boolean? = null,
    override val description: String? = null,
    override val kind: EnumDefnKindAutomation,
    @Serializable(with = MetaIdAutomationSer::class) override val metaId: Types.MetaIdAutomation,
    override val modules: StudioModuleSelection? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val secondary: String? = null,
    override val eventMap: StudioEntAutomationScheduledEventMap,
    override val scheduler: StudioVarValueScheduler? = null
) : StudioEntAutomationScheduled
