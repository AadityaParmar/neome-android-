package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntLogNumberFieldTransaction
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import com.neome.core.common.serializer.api.home.drawer.sig.SigUserAvatarData
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntLogNumberFieldTransactionData(
    override val createdOn: String,
    override val message: String? = null,
    override val operationKind: EnumDefnLogOperationKind,
    override val transactionId: String,
    override val userAvatar: SigUserAvatarData,
    override val value: Double
) : DtoEntLogNumberFieldTransaction
