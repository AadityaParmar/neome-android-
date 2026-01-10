package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroupFreezeSetting
import com.neome.api.ent.base.dto.DtoEntGroupFreezeSettingMap
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntGroupFreezeSettingData
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntGroupFreezeSettingMapData(
    override val groupMap: Map<@Serializable(with = GroupIdSer::class) Types.GroupId, DtoEntGroupFreezeSettingData>
) : DtoEntGroupFreezeSettingMap
