package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgWorkflowExecute
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgWorkflowExecuteData(
    @Serializable(with = MetaIdAutomationSer::class) override val automationId: Types.MetaIdAutomation? = null,
    override val formValue: FormValueRaw,
    @Serializable(with = RowIdSer::class) override val inputFormGridRowId: Types.RowId? = null,
    @Serializable(with = MetaIdVarSer::class) override val inputMappingVarId: Types.MetaIdVar? = null,
    override val workflowPointer: EntVdWorkflowPointer? = null
) : MsgWorkflowExecute
