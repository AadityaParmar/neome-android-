package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPrompt
import com.neome.api.meta.base.dto.StudioEntPromptMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPromptData
import com.neome.core.common.serializer.sysId.MetaIdPromptSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPromptMapData(
    @Serializable(with = MetaIdVarSer::class) override val adhocPromptMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val adhocPromptSpreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val fieldSeparatorSet: List<String>? = null,
    override val keys: List<@Serializable(with = MetaIdPromptSer::class) Types.MetaIdPrompt>,
    override val lineSeparator: String? = null,
    override val map: Map<@Serializable(with = MetaIdPromptSer::class) Types.MetaIdPrompt, StudioEntPromptData>,
    override val promptAttachmentFormat: EnumDefnPromptAttachmentFormat? = null,
    override val reviewBeforeExecuting: Boolean? = null,
    override val sendReviewDeeplinkOnError: Boolean? = null,
    override val sendSuccessDeeplink: Boolean? = null
) : StudioEntPromptMap
