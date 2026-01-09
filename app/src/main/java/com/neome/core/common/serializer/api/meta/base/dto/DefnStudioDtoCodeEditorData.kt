package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnStudioDtoCodeEditor
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioDtoCodeEditorData(
    override val aliasSpreadsheetIdSet: Array<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm>? = null,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm? = null,
    override val paramMap: Map<String, FormRefKey>? = null
) : DefnStudioDtoCodeEditor
