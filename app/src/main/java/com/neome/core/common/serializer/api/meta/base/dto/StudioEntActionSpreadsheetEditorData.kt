package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntAction
import com.neome.api.meta.base.dto.StudioEntActionSpreadsheetEditor
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class StudioEntActionSpreadsheetEditorData(
    override val aiInstructions: String? = null,
    override val defaultValueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>? = null,
    override val details: StudioDetailsData,
    override val icon: String? = null,
    override val increaseAsideWidth: Boolean? = null,
    override val kind: EnumDefnKindAction,
    @Serializable(with = MetaIdActionSer::class) override val metaId: Types.MetaIdAction,
    override val tooltip: String? = null,
    override val actionPermissionMap: StudioMapOfActionPermissionData? = null,
    override val bulkInsertRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val bulkUpdateFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val bulkUpdateRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val doNotOpenAside: Boolean? = null,
    override val filterConditionVarId: StudioValueVarIdConditionData? = null,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutSpreadsheetId: Types.MetaIdLayoutGrid? = null,
    override val readOnly: Boolean? = null,
    @Serializable(with = MetaIdGroupSer::class) override val sendMessageToGroupId: Types.MetaIdGroup? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : StudioEntActionSpreadsheetEditor
