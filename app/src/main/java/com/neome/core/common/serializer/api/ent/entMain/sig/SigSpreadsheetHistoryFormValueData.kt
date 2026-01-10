package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigSpreadsheetHistoryFormValue
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetHistoryFormValueData(
    override val defnForm: DefnFormData,
    override val formValue: FormValueRawData
) : SigSpreadsheetHistoryFormValue
