// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.nucleus.base.msg.Msg

open class MsgFormFieldTypeUpdate : Msg()
{
  lateinit var fieldId: MetaIdField
  lateinit var formId: MetaIdForm
  lateinit var newFieldType: EnumStudioCompType
}