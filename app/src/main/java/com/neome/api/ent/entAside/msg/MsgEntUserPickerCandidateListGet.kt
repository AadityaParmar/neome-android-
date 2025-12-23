// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntUserPickerCandidateListGet : Msg() {
    var formValueRaw: FormValueRaw? = null
    var roleIdSet: Array<MetaIdRole>? = null
    var setOfUserVarId: MetaIdVar? = null
    lateinit var sourceFormId: MetaIdForm
}
