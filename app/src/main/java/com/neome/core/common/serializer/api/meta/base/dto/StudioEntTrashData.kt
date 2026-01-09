package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioComposite
import com.neome.api.meta.base.dto.StudioDtoLayoutForm
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioDtoLayoutUser
import com.neome.api.meta.base.dto.StudioEntAction
import com.neome.api.meta.base.dto.StudioEntGroup
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioEntRole
import com.neome.api.meta.base.dto.StudioEntSpreadsheet
import com.neome.api.meta.base.dto.StudioEntTrash
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioForm
import com.neome.api.meta.base.dto.StudioVar
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutUserSer
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntTrashData(
    override val actionMap: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, StudioEntAction>? = null,
    override val compositeMap: Map<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite, StudioComposite>? = null,
    override val contentMap: Map<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm, StudioDtoLayoutForm>? = null,
    override val fieldMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, StudioField>? = null,
    override val formMap: Map<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm, StudioForm>? = null,
    override val groupMap: Map<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup, StudioEntGroup>? = null,
    override val layoutGridMap: Map<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid, StudioDtoLayoutGrid>? = null,
    override val layoutUserMap: Map<@Serializable(with = MetaIdLayoutUserSer::class) Types.MetaIdLayoutUser, StudioDtoLayoutUser>? = null,
    override val moduleMap: Map<@Serializable(with = MetaIdModuleSer::class) Types.MetaIdModule, String>? = null,
    override val reportMap: Map<@Serializable(with = MetaIdReportSer::class) Types.MetaIdReport, StudioEntReport>? = null,
    override val roleMap: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, StudioEntRole>? = null,
    override val spreadsheetMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, StudioEntSpreadsheet>? = null,
    override val varMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, StudioVar>? = null
) : StudioEntTrash
