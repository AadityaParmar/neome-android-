// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.MetaIdVar

interface DefnStudioBuildArgBinder : DefnField
{
  val compositeIdSet: Array<MetaIdComposite>?
  val derivedCompositeIdSet: Array<MetaIdComposite>?
  val derivedFormId: MetaIdForm?
  val derivedPluginId: MetaIdPlugin?
  val direction: EnumDefnThemeDirection?
  val excludeFieldIdSet: Array<MetaIdField>?
  val excludeVarIdSet: Array<MetaIdVar>?
  val filterConstantFieldTypeSet: Array<EnumDefnCompType>?
  val filterContextCallerSet: Array<String>?
  val filterContextCallerSettingSet: Array<String>?
  val filterContextEntSet: Array<String>?
  val filterContextOptionSet: Array<String>?
  val filterContextRowSet: Array<String>?
  val filterDerivedFieldTypeSet: Array<EnumDefnCompType>?
  val filterFieldTypeSet: Array<EnumDefnCompType>?
  val filterKindSet: Array<EnumDefnArgBinder>?
  val filterVarKindSet: Array<EnumStudioVarKind>?
  val formId: MetaIdForm?
  val gridId: MetaIdGrid?
  val includeOptionMap: DefnStudioMapOfDtoOption?
  val inputFormId: MetaIdForm?
  val peerFieldId: MetaIdField?
  val peerKind: EnumDefnArgBinder?
  val pluginConfigFormId: MetaIdForm?
  val pluginId: MetaIdPlugin?
  val refTargetFieldId: MetaIdField?
  val refTargetFormId: MetaIdForm?
  val required: Boolean?
}