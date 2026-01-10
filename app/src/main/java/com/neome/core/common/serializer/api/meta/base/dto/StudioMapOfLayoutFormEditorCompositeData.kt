package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutFormEditorComposite
import com.neome.api.meta.base.dto.StudioMapOfLayoutFormEditorComposite
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoLayoutFormEditorCompositeData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormEditorCompositeSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfLayoutFormEditorCompositeData(
    override val keys: List<@Serializable(with = MetaIdLayoutFormEditorCompositeSer::class) Types.MetaIdLayoutFormEditorComposite>,
    override val map: Map<@Serializable(with = MetaIdLayoutFormEditorCompositeSer::class) Types.MetaIdLayoutFormEditorComposite, StudioDtoLayoutFormEditorCompositeData>
) : StudioMapOfLayoutFormEditorComposite
