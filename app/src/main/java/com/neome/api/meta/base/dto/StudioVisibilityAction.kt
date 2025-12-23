// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnVisibilityAction
import com.neome.api.meta.base.Types.EnumDefnVisibilityActionOn
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.MetaIdVisibilityAction

open class StudioVisibilityAction : StudioBase() {
    var actionId: MetaIdAction? = null
    var compIdSet: Array<MetaIdComp>? = null
    var groupIdSet: Array<MetaIdGroup>? = null
    var layoutIdSet: Array<MetaIdLayoutForm>? = null
    var mappingVarId: MetaIdVar? = null
    lateinit var metaId: MetaIdVisibilityAction
    lateinit var name: Symbol
    var source: StudioBuildArgBinder? = null
    lateinit var visibilityAction: EnumDefnVisibilityAction
    var visibilityActionOn: EnumDefnVisibilityActionOn? = null
}
