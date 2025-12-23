// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPrompt

open class StudioEntPromptMap : StudioBase()
{
  var adhocPromptMappingVarId: MetaIdVar? = null
  var adhocPromptSpreadsheetId: MetaIdSpreadsheet? = null
  var fieldSeparatorSet: Array<String>? = null
  lateinit var keys: Array<MetaIdPrompt>
  var lineSeparator: String? = null
  lateinit var map: Map<MetaIdPrompt, StudioEntPrompt>
  var promptAttachmentFormat: EnumDefnPromptAttachmentFormat? = null
  var reviewBeforeExecuting: Boolean? = null
  var sendReviewDeeplinkOnError: Boolean? = null
  var sendSuccessDeeplink: Boolean? = null
}