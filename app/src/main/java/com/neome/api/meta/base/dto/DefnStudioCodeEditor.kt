// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldParagraph
import com.neome.api.meta.base.dto.DefnStudioDtoCodeEditor
import com.neome.api.meta.base.Types.EnumDefnCodeEditorLanguage

interface DefnStudioCodeEditor : DefnFieldParagraph
{
  val allowCopy: Boolean?
  val autoCompletePayload: DefnStudioDtoCodeEditor?
  val enableLineNumbers: Boolean?
  val enableMiniMap: Boolean?
  val excludeAiInput: Boolean?
  val language: EnumDefnCodeEditorLanguage?
  val minHeight: Long?
  val showExpandBtn: Boolean?
  val title: String?
}