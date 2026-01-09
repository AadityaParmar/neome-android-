package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnVisibilityAction
import com.neome.api.meta.base.dto.DefnVisibilityActionMap
import com.neome.core.common.serializer.sysId.MetaIdVisibilityActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnVisibilityActionMapData(
    override val keys: Array<@Serializable(with = MetaIdVisibilityActionSer::class) Types.MetaIdVisibilityAction>,
    override val map: Map<@Serializable(with = MetaIdVisibilityActionSer::class) Types.MetaIdVisibilityAction, DefnVisibilityAction>
) : DefnVisibilityActionMap
