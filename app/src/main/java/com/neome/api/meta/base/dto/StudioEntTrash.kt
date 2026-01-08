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

interface StudioEntTrash
{
  val actionMap: Map<MetaIdAction, StudioEntAction>?
  val compositeMap: Map<MetaIdComposite, StudioComposite>?
  val contentMap: Map<MetaIdLayoutForm, StudioDtoLayoutForm>?
  val fieldMap: Map<MetaIdField, StudioField>?
  val formMap: Map<MetaIdForm, StudioForm>?
  val groupMap: Map<MetaIdGroup, StudioEntGroup>?
  val layoutGridMap: Map<MetaIdLayoutGrid, StudioDtoLayoutGrid>?
  val layoutUserMap: Map<MetaIdLayoutUser, StudioDtoLayoutUser>?
  val moduleMap: Map<MetaIdModule, String>?
  val reportMap: Map<MetaIdReport, StudioEntReport>?
  val roleMap: Map<MetaIdRole, StudioEntRole>?
  val spreadsheetMap: Map<MetaIdSpreadsheet, StudioEntSpreadsheet>?
  val varMap: Map<MetaIdVar, StudioVar>?
}