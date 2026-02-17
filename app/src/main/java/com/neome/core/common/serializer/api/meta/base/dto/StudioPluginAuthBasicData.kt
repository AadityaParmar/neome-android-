package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPluginAuthMethod
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioPluginAuthBase
import com.neome.api.meta.base.dto.StudioPluginAuthBasic
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleSelectionData
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginAuthBasicData(
    override val description: String? = null,
    override val kind: EnumDefnPluginAuthMethod,
    @Serializable(with = MetaIdAuthMethodSer::class) override val metaId: Types.MetaIdAuthMethod,
    override val modules: StudioModuleSelectionData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol
) : StudioPluginAuthBasic
