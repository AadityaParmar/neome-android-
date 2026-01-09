package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigSpreadsheetHistoryFormValue
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetHistoryFormValueData(
    override val defnForm: DefnForm,
    override val formValue: FormValueRaw
) : SigSpreadsheetHistoryFormValue
