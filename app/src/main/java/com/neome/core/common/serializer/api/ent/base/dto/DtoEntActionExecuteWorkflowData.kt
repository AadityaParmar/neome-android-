package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.ent.base.dto.DtoEntActionExecuteWorkflow
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntActionExecuteWorkflowData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val description: String? = null,
    override val icon: String? = null,
    override val increaseAsideWidth: Boolean? = null,
    override val kind: EnumDefnKindAction,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val tooltip: String? = null,
    @Serializable(with = MetaIdFormSer::class) override val automationFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdAutomationSer::class) override val automationId: Types.MetaIdAutomation? = null,
    override val workflowPointer: EntVdWorkflowPointer? = null
) : DtoEntActionExecuteWorkflow
