// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioEntPromptMap : StudioBase {
    val adhocPromptMappingVarId: MetaIdVar?
    val adhocPromptSpreadsheetId: MetaIdSpreadsheet?
    val fieldSeparatorSet: List<String>?
    val keys: List<MetaIdPrompt>
    val lineSeparator: String?
    val map: Map<MetaIdPrompt, StudioEntPrompt>
    val promptAttachmentFormat: EnumDefnPromptAttachmentFormat?
    val reviewBeforeExecuting: Boolean?
    val sendReviewDeeplinkOnError: Boolean?
    val sendSuccessDeeplink: Boolean?
}
