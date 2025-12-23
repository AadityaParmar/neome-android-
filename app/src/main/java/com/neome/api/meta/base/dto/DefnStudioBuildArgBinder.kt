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

open class DefnStudioBuildArgBinder : DefnField()
{
  var compositeIdSet: Array<MetaIdComposite>? = null
  var derivedCompositeIdSet: Array<MetaIdComposite>? = null
  var derivedFormId: MetaIdForm? = null
  var derivedPluginId: MetaIdPlugin? = null
  var direction: EnumDefnThemeDirection? = null
  var excludeFieldIdSet: Array<MetaIdField>? = null
  var excludeVarIdSet: Array<MetaIdVar>? = null
  var filterConstantFieldTypeSet: Array<EnumDefnCompType>? = null
  var filterContextCallerSet: Array<String>? = null
  var filterContextCallerSettingSet: Array<String>? = null
  var filterContextEntSet: Array<String>? = null
  var filterContextOptionSet: Array<String>? = null
  var filterContextRowSet: Array<String>? = null
  var filterDerivedFieldTypeSet: Array<EnumDefnCompType>? = null
  var filterFieldTypeSet: Array<EnumDefnCompType>? = null
  var filterKindSet: Array<EnumDefnArgBinder>? = null
  var filterVarKindSet: Array<EnumStudioVarKind>? = null
  var formId: MetaIdForm? = null
  var gridId: MetaIdGrid? = null
  var includeOptionMap: DefnStudioMapOfDtoOption? = null
  var inputFormId: MetaIdForm? = null
  var peerFieldId: MetaIdField? = null
  var peerKind: EnumDefnArgBinder? = null
  var pluginConfigFormId: MetaIdForm? = null
  var pluginId: MetaIdPlugin? = null
  var refTargetFieldId: MetaIdField? = null
  var refTargetFormId: MetaIdForm? = null
  var required: Boolean? = null
}