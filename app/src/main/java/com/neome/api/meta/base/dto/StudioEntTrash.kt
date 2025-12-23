// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
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
import com.neome.api.meta.base.dto.StudioComposite
import com.neome.api.meta.base.dto.StudioDtoLayoutForm
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioDtoLayoutUser
import com.neome.api.meta.base.dto.StudioEntAction
import com.neome.api.meta.base.dto.StudioEntGroup
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioEntRole
import com.neome.api.meta.base.dto.StudioEntSpreadsheet
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioForm
import com.neome.api.meta.base.dto.StudioVar

open class StudioEntTrash
{
  var actionMap: Map<MetaIdAction, StudioEntAction>? = null
  var compositeMap: Map<MetaIdComposite, StudioComposite>? = null
  var contentMap: Map<MetaIdLayoutForm, StudioDtoLayoutForm>? = null
  var fieldMap: Map<MetaIdField, StudioField>? = null
  var formMap: Map<MetaIdForm, StudioForm>? = null
  var groupMap: Map<MetaIdGroup, StudioEntGroup>? = null
  var layoutGridMap: Map<MetaIdLayoutGrid, StudioDtoLayoutGrid>? = null
  var layoutUserMap: Map<MetaIdLayoutUser, StudioDtoLayoutUser>? = null
  var moduleMap: Map<MetaIdModule, String>? = null
  var reportMap: Map<MetaIdReport, StudioEntReport>? = null
  var roleMap: Map<MetaIdRole, StudioEntRole>? = null
  var spreadsheetMap: Map<MetaIdSpreadsheet, StudioEntSpreadsheet>? = null
  var varMap: Map<MetaIdVar, StudioVar>? = null
}