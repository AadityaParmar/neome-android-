package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioPluginApi
import com.neome.api.meta.base.dto.StudioPluginApiBody
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginApiData(
    override val apiType: EnumDefnPluginApiMethod,
    override val baseURLVarId: StudioValueVarIdText? = null,
    override val creationDate: String,
    override val description: String? = null,
    override val guaranteedInvocation: Boolean? = null,
    override val headerParamMap: StudioMapOfArgBinder? = null,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    @Serializable(with = PluginApiIdSer::class) override val metaId: Types.PluginApiId,
    override val modules: StudioModuleSelection? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm? = null,
    override val queryParamMap: StudioMapOfArgBinder? = null,
    override val requestBody: StudioPluginApiBody? = null,
    override val responseBody: StudioPluginApiBody? = null
) : StudioPluginApi
