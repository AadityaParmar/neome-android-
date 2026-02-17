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

interface StudioEntPrompt : StudioBase
{
  val actionId: MetaIdAction?
  val metaId: MetaIdPrompt
  val modules: StudioModuleSelection?
  val name: Symbol
  val permissionRoleIdSet: List<MetaIdRole>?
  val promptAttachmentFormat: EnumDefnPromptAttachmentFormat?
  val promptText: StudioValueCodeJavascript?
  val reviewBeforeExecuting: Boolean?
  val sendReviewDeeplinkOnError: Boolean?
  val sendSuccessDeeplink: Boolean?
}