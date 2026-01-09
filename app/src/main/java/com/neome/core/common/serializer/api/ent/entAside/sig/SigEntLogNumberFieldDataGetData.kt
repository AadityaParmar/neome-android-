package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.base.dto.DtoEntLogNumberFieldTransaction
import com.neome.api.ent.entAside.sig.SigEntLogNumberFieldDataGet
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigEntLogNumberFieldDataGetData(
    override val transactionList: Array<DtoEntLogNumberFieldTransaction>
) : SigEntLogNumberFieldDataGet
