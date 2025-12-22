// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCodeEditorLanguage

class DefnStudioCodeEditor : DefnFieldParagraph() {
    var allowCopy: boolean? = null
    var autoCompletePayload: DefnStudioDtoCodeEditor? = null
    var enableLineNumbers: boolean? = null
    var enableMiniMap: boolean? = null
    var excludeAiInput: boolean? = null
    var language: EnumDefnCodeEditorLanguage? = null
    var minHeight: number? = null
    var showExpandBtn: boolean? = null
    var title: string? = null
}
