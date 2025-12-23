// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import java.util.Map
import com.neome.api.nucleus.base.msg.Msg

open class MsgContactUs : Msg()
{
  var attrMap: Map<String, String>? = null
  var companyName: String? = null
  var content: String? = null
  var email: String? = null
  var fullName: String? = null
  var mobileNumber: String? = null
  var pageName: String? = null
}