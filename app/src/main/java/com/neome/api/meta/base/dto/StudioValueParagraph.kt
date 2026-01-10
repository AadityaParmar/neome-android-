// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

interface StudioValueParagraph : StudioValueVarIdBase {
    val paramSet: List<String>?
    val value: String
}
