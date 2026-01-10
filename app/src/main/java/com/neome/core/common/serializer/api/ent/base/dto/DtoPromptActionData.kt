package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoPromptAction
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValue
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdPromptSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoPromptActionData(
    override val executeOnClient: Boolean,
    override val formValue: FormValueData? = null,
    @Serializable(with = MetaIdActionSer::class) override val promptActionId: Types.MetaIdAction? = null,
    @Serializable(with = MetaIdPromptSer::class) override val promptId: Types.MetaIdPrompt? = null,
    @Serializable(with = MetaIdFormSer::class) override val ragFormId: Types.MetaIdForm? = null
) : DtoPromptAction
