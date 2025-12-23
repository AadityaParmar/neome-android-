// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.core.base.msg.MsgVersion

open class MsgFormId : MsgVersion()
{
  lateinit var formId: MetaIdForm
}