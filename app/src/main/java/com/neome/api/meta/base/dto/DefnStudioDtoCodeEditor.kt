// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

interface DefnStudioDtoCodeEditor {
    val aliasSpreadsheetIdSet: List<MetaIdForm>?
    val inputFormId: MetaIdForm?
    val outputFormId: MetaIdForm?
    val paramMap: Map<String, FormRefKey>?
}
