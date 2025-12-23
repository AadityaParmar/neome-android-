// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.Sig

open class SigSpreadsheetHistoryFormValue : Sig() {
    lateinit var defnForm: DefnForm
    lateinit var formValue: FormValueRaw
}
