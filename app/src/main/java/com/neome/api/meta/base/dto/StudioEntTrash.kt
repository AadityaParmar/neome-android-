// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntTrash {
    var actionMap: Record<MetaIdAction, StudioEntAction>? = null
    var compositeMap: Record<MetaIdComposite, StudioComposite>? = null
    var contentMap: Record<MetaIdLayoutForm, StudioDtoLayoutForm>? = null
    var fieldMap: Record<MetaIdField, StudioField>? = null
    var formMap: Record<MetaIdForm, StudioForm>? = null
    var groupMap: Record<MetaIdGroup, StudioEntGroup>? = null
    var layoutGridMap: Record<MetaIdLayoutGrid, StudioDtoLayoutGrid>? = null
    var layoutUserMap: Record<MetaIdLayoutUser, StudioDtoLayoutUser>? = null
    var moduleMap: Record<MetaIdModule, string>? = null
    var reportMap: Record<MetaIdReport, StudioEntReport>? = null
    var roleMap: Record<MetaIdRole, StudioEntRole>? = null
    var spreadsheetMap: Record<MetaIdSpreadsheet, StudioEntSpreadsheet>? = null
    var varMap: Record<MetaIdVar, StudioVar>? = null
}
