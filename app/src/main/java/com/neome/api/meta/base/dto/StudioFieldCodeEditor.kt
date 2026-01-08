// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCodeEditorLanguage
import com.neome.api.meta.base.dto.StudioFieldParagraph

interface StudioFieldCodeEditor : StudioFieldParagraph
{
  val enableLineNumbers: Boolean?
  val enableMiniMap: Boolean?
  val language: EnumDefnCodeEditorLanguage?
  val showExpandBtn: Boolean?
  val title: String?
}