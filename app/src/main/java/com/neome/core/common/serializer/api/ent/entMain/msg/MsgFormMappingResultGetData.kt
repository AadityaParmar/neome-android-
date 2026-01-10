package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgFormMappingResultGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgFormMappingResultGetData(
    @Serializable(with = RowIdSer::class) override val inputFormGridRowId: Types.RowId? = null,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm,
    override val inputFormValueRaw: FormValueRawData,
    @Serializable(with = MetaIdVarSer::class) override val mappingVarId: Types.MetaIdVar,
    @Serializable(with = RowIdSer::class) override val outputFormGridRowId: Types.RowId? = null,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm,
    override val outputFormValueRaw: FormValueRawData? = null
) : MsgFormMappingResultGet
