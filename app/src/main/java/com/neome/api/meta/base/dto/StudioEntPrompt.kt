// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.Types.MetaIdRole

class StudioEntPrompt : StudioBase() {
    var actionId: MetaIdAction? = null
    val metaId: MetaIdPrompt
    var modules: StudioModuleSelection? = null
    val name: Symbol
    var permissionRoleIdSet: MetaIdRole[]? = null
    var promptAttachmentFormat: EnumDefnPromptAttachmentFormat? = null
    var promptText: StudioValueCodeJavascript? = null
    var reviewBeforeExecuting: boolean? = null
    var sendReviewDeeplinkOnError: boolean? = null
    var sendSuccessDeeplink: boolean? = null
}
