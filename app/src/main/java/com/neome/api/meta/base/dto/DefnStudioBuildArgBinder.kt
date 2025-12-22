// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

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

class DefnStudioBuildArgBinder : DefnField() {
    var compositeIdSet: MetaIdComposite[]? = null
    var derivedCompositeIdSet: MetaIdComposite[]? = null
    var derivedFormId: MetaIdForm? = null
    var derivedPluginId: MetaIdPlugin? = null
    var direction: EnumDefnThemeDirection? = null
    var excludeFieldIdSet: MetaIdField[]? = null
    var excludeVarIdSet: MetaIdVar[]? = null
    var filterConstantFieldTypeSet: EnumDefnCompType[]? = null
    var filterContextCallerSet: string[]? = null
    var filterContextCallerSettingSet: string[]? = null
    var filterContextEntSet: string[]? = null
    var filterContextOptionSet: string[]? = null
    var filterContextRowSet: string[]? = null
    var filterDerivedFieldTypeSet: EnumDefnCompType[]? = null
    var filterFieldTypeSet: EnumDefnCompType[]? = null
    var filterKindSet: EnumDefnArgBinder[]? = null
    var filterVarKindSet: EnumStudioVarKind[]? = null
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
    var required: boolean? = null
}
