package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPluginApi
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioPluginApiBody
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPluginApiData(
    override val apiType: EnumDefnPluginApiMethod,
    override val baseURL: String? = null,
    override val guaranteedInvocation: Boolean? = null,
    override val headerParamMap: StudioMapOfArgBinder? = null,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm? = null,
    @Serializable(with = PluginApiIdSer::class) override val pluginApiId: Types.PluginApiId,
    override val queryParamMap: StudioMapOfArgBinder? = null,
    override val requestBody: StudioPluginApiBody? = null,
    override val responseBody: StudioPluginApiBody? = null
) : StudioEntPluginApi
