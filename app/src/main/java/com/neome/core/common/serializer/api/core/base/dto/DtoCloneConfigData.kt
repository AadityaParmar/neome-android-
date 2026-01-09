package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoCloneConfig
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoCloneConfigData(
    override val cloneAdmin: Boolean? = null,
    override val cloneEntUser: Boolean? = null,
    override val cloneSpreadsheetIdSet: Array<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet>? = null
) : DtoCloneConfig
