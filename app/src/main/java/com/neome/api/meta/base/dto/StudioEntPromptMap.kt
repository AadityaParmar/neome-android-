// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntPromptMap : StudioBase() {
    var adhocPromptMappingVarId: MetaIdVar? = null
    var adhocPromptSpreadsheetId: MetaIdSpreadsheet? = null
    var fieldSeparatorSet: string[]? = null
    val keys: MetaIdPrompt[]
    var lineSeparator: string? = null
    val map: Record<MetaIdPrompt, StudioEntPrompt>
    var promptAttachmentFormat: EnumDefnPromptAttachmentFormat? = null
    var reviewBeforeExecuting: boolean? = null
    var sendReviewDeeplinkOnError: boolean? = null
    var sendSuccessDeeplink: boolean? = null
}
