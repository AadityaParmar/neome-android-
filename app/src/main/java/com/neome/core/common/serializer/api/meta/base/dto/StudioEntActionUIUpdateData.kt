package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.EnumDefnKindActionUIUpdate
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntAction
import com.neome.api.meta.base.dto.StudioEntActionUIUpdate
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class StudioEntActionUIUpdateData(
    override val aiInstructions: String? = null,
    override val defaultValueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>? = null,
    override val details: StudioDetailsData,
    override val icon: String? = null,
    override val increaseAsideWidth: Boolean? = null,
    override val kind: EnumDefnKindAction,
    @Serializable(with = MetaIdActionSer::class) override val metaId: Types.MetaIdAction,
    override val tooltip: String? = null,
    @Serializable(with = MetaIdGroupSer::class) override val groupId: Types.MetaIdGroup? = null,
    override val updateKind: EnumDefnKindActionUIUpdate? = null
) : StudioEntActionUIUpdate
