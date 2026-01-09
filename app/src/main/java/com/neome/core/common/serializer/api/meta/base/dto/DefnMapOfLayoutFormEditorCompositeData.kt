package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnLayoutFormEditorComposite
import com.neome.api.meta.base.dto.DefnMapOfLayoutFormEditorComposite
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormEditorCompositeSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnMapOfLayoutFormEditorCompositeData(
    override val keys: Array<@Serializable(with = MetaIdLayoutFormEditorCompositeSer::class) Types.MetaIdLayoutFormEditorComposite>,
    override val map: Map<@Serializable(with = MetaIdLayoutFormEditorCompositeSer::class) Types.MetaIdLayoutFormEditorComposite, DefnLayoutFormEditorComposite>
) : DefnMapOfLayoutFormEditorComposite
