package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioPluginBundle
import com.neome.api.meta.base.dto.StudioPluginBundleBase
import com.neome.api.meta.base.dto.StudioPluginDraft
import com.neome.api.meta.base.dto.StudioPluginMap
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.PluginBundleIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginBundleData(
    @Serializable(with = AdminIdSer::class) override val createdBy: Types.AdminId,
    override val creationTime: String,
    override val deployMap: StudioPluginMap? = null,
    @Serializable(with = PluginBundleIdSer::class) override val pluginBundleId: Types.PluginBundleId,
    @Serializable(with = AdminIdSer::class) override val updateBy: Types.AdminId,
    override val updateTime: String,
    override val version: String,
    override val draft: StudioPluginDraft? = null
) : StudioPluginBundle
