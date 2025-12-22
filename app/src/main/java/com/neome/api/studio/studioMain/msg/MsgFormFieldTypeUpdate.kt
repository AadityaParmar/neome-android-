// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.nucleus.base.msg.Msg

class MsgFormFieldTypeUpdate : Msg() {
    val fieldId: MetaIdField
    val formId: MetaIdForm
    val newFieldType: EnumStudioCompType
}
