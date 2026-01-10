package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPrompt
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleSelectionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueCodeJavascriptData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdPromptSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPromptData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null,
    @Serializable(with = MetaIdPromptSer::class) override val metaId: Types.MetaIdPrompt,
    override val modules: StudioModuleSelectionData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val permissionRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val promptAttachmentFormat: EnumDefnPromptAttachmentFormat? = null,
    override val promptText: StudioValueCodeJavascriptData? = null,
    override val reviewBeforeExecuting: Boolean? = null,
    override val sendReviewDeeplinkOnError: Boolean? = null,
    override val sendSuccessDeeplink: Boolean? = null
) : StudioEntPrompt
