// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.SigVersion

interface SigSpreadsheetRowCommentCount : SigVersion
{
  val commentCount: Long?
  val unreadCommentCount: Long?
}