// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.SigVersion

open class SigSpreadsheetRowCommentCount : SigVersion()
{
  var commentCount: Number? = null
  var unreadCommentCount: Number? = null
}