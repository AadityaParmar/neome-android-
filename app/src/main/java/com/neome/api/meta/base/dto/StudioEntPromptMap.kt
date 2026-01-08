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

interface StudioEntPromptMap : StudioBase
{
  val adhocPromptMappingVarId: MetaIdVar?
  val adhocPromptSpreadsheetId: MetaIdSpreadsheet?
  val fieldSeparatorSet: Array<String>?
  val keys: Array<MetaIdPrompt>
  val lineSeparator: String?
  val map: Map<MetaIdPrompt, StudioEntPrompt>
  val promptAttachmentFormat: EnumDefnPromptAttachmentFormat?
  val reviewBeforeExecuting: Boolean?
  val sendReviewDeeplinkOnError: Boolean?
  val sendSuccessDeeplink: Boolean?
}