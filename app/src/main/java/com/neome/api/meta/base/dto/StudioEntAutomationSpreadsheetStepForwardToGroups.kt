// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntAutomationSpreadsheetStepForwardToGroups : StudioEntAutomationStep() {
    var dataSourceRoleIdSet: Array<MetaIdRole>? = null
    var formDataSourcePipelineVarId: MetaIdPipelineParam? = null
    var groupIdSet: Array<MetaIdGroup>? = null
    var senderFieldId: MetaIdField? = null
    var senderFormPipelineVarId: MetaIdPipelineParam? = null
    var senderRoleId: MetaIdRole? = null
    var setOfUserVarId: MetaIdVar? = null
}
