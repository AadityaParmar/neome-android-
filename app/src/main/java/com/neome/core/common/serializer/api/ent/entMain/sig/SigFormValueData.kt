package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigFormValue
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import kotlinx.serialization.Serializable


@Serializable
data class SigFormValueData(
    override val formValue: FormValueData
) : SigFormValue
