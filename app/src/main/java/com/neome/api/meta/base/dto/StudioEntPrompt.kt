// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.api.meta.base.Symbol

open class StudioEntPrompt : StudioBase()
{
  var actionId: MetaIdAction? = null
  lateinit var metaId: MetaIdPrompt
  var modules: StudioModuleSelection? = null
  lateinit var name: Symbol
  var permissionRoleIdSet: Array<MetaIdRole>? = null
  var promptAttachmentFormat: EnumDefnPromptAttachmentFormat? = null
  var promptText: StudioValueCodeJavascript? = null
  var reviewBeforeExecuting: Boolean? = null
  var sendReviewDeeplinkOnError: Boolean? = null
  var sendSuccessDeeplink: Boolean? = null
}