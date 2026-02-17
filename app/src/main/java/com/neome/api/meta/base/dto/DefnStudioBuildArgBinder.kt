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
  val compositeIdSet: List<MetaIdComposite>?
  val derivedCompositeIdSet: List<MetaIdComposite>?
  val derivedFormId: MetaIdForm?
  val derivedPluginId: MetaIdPlugin?
  val direction: EnumDefnThemeDirection?
  val excludeFieldIdSet: List<MetaIdField>?
  val excludeVarIdSet: List<MetaIdVar>?
  val filterConstantFieldTypeSet: List<EnumDefnCompType>?
  val filterContextCallerSet: List<String>?
  val filterContextCallerSettingSet: List<String>?
  val filterContextEntSet: List<String>?
  val filterContextOptionSet: List<String>?
  val filterContextRowSet: List<String>?
  val filterDerivedFieldTypeSet: List<EnumDefnCompType>?
  val filterFieldTypeSet: List<EnumDefnCompType>?
  val filterKindSet: List<EnumDefnArgBinder>?
  val filterVarKindSet: List<EnumStudioVarKind>?
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