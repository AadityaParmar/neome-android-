// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig

class SigFormMappingResultGet : Sig() {
    val formId: MetaIdForm
    val formValue: FormValue
    var outputFieldIdSet: MetaIdField[]? = null
}
