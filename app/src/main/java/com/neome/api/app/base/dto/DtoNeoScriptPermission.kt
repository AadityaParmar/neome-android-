// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DtoNeoScriptPermission : DtoNeoScript() {
    var compositeId: MetaIdComposite? = null
    var fieldId: MetaIdField? = null
    var formId: MetaIdForm? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
