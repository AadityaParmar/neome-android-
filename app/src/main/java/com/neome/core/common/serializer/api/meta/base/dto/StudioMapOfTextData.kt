package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinderHolder
import com.neome.api.meta.base.dto.StudioMapOfText
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfTextData(
    override val keys: Array<String>,
    override val map: Map<String, StudioBuildArgBinderHolder>,
    @Serializable(with = MetaIdFormSer::class) override val sourceFormId: Types.MetaIdForm? = null
) : StudioMapOfText
