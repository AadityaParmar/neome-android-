package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.dto.StoreItem
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEnt
import com.neome.api.meta.base.dto.StudioPluginBundle
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginBundleData
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.StoreItemIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StoreItemData(
    override val artifactKind: EnumStoreItemArtifact,
    @Serializable(with = AdminIdSer::class) override val createdBy: Types.AdminId? = null,
    override val createdOn: String? = null,
    override val pluginBundle: StudioPluginBundleData? = null,
    @Serializable(with = EntIdSer::class) override val seedEntId: Types.EntId? = null,
    @Serializable(with = StoreItemIdSer::class) override val storeItemId: Types.StoreItemId,
    override val studioEnt: StudioEntData? = null,
    @Serializable(with = AdminIdSer::class) override val updatedBy: Types.AdminId? = null,
    override val updatedOn: String? = null
) : StoreItem
