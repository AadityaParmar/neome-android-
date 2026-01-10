package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioValueVarIdBase
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfArgBinderData
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioValueVarIdParagraphData(
    override val argBinderMap: StudioMapOfArgBinderData? = null,
    @Serializable(with = MetaIdVarSer::class) override val argVarId: Types.MetaIdVar
) : StudioValueVarIdParagraph
