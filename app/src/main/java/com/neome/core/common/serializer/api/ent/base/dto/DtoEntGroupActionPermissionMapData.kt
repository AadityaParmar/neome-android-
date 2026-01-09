package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntActionPermission
import com.neome.api.ent.base.dto.DtoEntGroupActionPermissionMap
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntGroupActionPermissionMapData(
    @Serializable(with = MetaIdActionSer::class) override val defaultActionId: Types.MetaIdAction? = null,
    override val defaultPinnedActionIdSet: Array<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>? = null,
    override val hideActionMenu: Boolean? = null,
    override val keys: Array<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>,
    override val map: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, DtoEntActionPermission>,
    override val mobilePinnedActionIdSet: Array<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>? = null
) : DtoEntGroupActionPermissionMap
