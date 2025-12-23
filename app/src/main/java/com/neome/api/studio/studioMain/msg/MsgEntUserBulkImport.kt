// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.studio.base.dto.DtoEntUserImport
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntUserBulkImport : Msg()
{
  lateinit var users: Array<DtoEntUserImport>
}