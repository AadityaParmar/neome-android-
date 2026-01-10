package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoPluginApiRequestPayload
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntUserIdTriple
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.common.serializer.api.meta.base.dto.EntUserIdTripleData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import com.neome.core.common.serializer.sysId.RequestIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoPluginApiRequestPayloadData(
    override val callerTriplet: EntUserIdTripleData? = null,
    @Serializable(with = PluginApiIdSer::class) override val pluginApiId: Types.PluginApiId,
    @Serializable(with = MetaIdPluginSer::class) override val pluginId: Types.MetaIdPlugin,
    override val pluginInputFormValue: FormValueRawData? = null,
    @Serializable(with = RequestIdSer::class) override val requestId: Types.RequestId,
    override val responseActorPath: String
) : DtoPluginApiRequestPayload
