// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import java.util.Map
import com.neome.api.nucleus.base.msg.Msg

interface MsgContactUs : Msg
{
  val attrMap: Map<String, String>?
  val companyName: String?
  val content: String?
  val email: String?
  val fullName: String?
  val mobileNumber: String?
  val pageName: String?
}