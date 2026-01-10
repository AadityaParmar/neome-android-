package com.neome.core.common.serializer.api.ent.entDrawer.sig

import com.neome.api.ent.base.dto.DtoEntGroupFreezeSettingMap
import com.neome.api.ent.entDrawer.sig.SigEntFreezeGroupListGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntGroupFreezeSettingMapData
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigEntFreezeGroupListGetData(
    override val entMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, DtoEntGroupFreezeSettingMapData>
) : SigEntFreezeGroupListGet
