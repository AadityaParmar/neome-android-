package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgButtonWorkflowExecute
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgButtonWorkflowExecuteData(
    @Serializable(with = MetaIdFieldSer::class) override val buttonFieldId: Types.MetaIdField,
    @Serializable(with = MetaIdFormSer::class) override val buttonFormId: Types.MetaIdForm,
    override val formValue: FormValueRawData,
    @Serializable(with = MetaIdGridSer::class) override val fromGridId: Types.MetaIdGrid? = null,
    @Serializable(with = RowIdSer::class) override val fromGridRowId: Types.RowId? = null
) : MsgButtonWorkflowExecute
