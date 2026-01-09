package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindImport
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntImport
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntImportData(
    override val description: String? = null,
    override val kind: EnumDefnKindImport? = null,
    @Serializable(with = MetaIdPluginSer::class) override val metaId: Types.MetaIdPlugin,
    override val modules: StudioModuleSelection? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null
) : StudioEntImport
