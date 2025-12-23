// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCodeEditorLanguage

open class StudioFieldCodeEditor : StudioFieldParagraph() {
    var enableLineNumbers: Boolean? = null
    var enableMiniMap: Boolean? = null
    var language: EnumDefnCodeEditorLanguage? = null
    var showExpandBtn: Boolean? = null
    var title: String? = null
}
