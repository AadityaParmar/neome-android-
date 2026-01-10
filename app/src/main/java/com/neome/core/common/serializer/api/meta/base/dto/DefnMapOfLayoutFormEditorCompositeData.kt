package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnLayoutFormEditorComposite
import com.neome.api.meta.base.dto.DefnMapOfLayoutFormEditorComposite
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutFormEditorCompositeData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormEditorCompositeSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnMapOfLayoutFormEditorCompositeData(
    override val keys: List<@Serializable(with = MetaIdLayoutFormEditorCompositeSer::class) Types.MetaIdLayoutFormEditorComposite>,
    override val map: Map<@Serializable(with = MetaIdLayoutFormEditorCompositeSer::class) Types.MetaIdLayoutFormEditorComposite, DefnLayoutFormEditorCompositeData>
) : DefnMapOfLayoutFormEditorComposite
