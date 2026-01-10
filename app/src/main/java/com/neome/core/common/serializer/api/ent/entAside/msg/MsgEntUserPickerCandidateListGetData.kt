package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.entAside.msg.MsgEntUserPickerCandidateListGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntUserPickerCandidateListGetData(
    override val formValueRaw: FormValueRawData? = null,
    override val roleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val setOfUserVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFormSer::class) override val sourceFormId: Types.MetaIdForm
) : MsgEntUserPickerCandidateListGet
