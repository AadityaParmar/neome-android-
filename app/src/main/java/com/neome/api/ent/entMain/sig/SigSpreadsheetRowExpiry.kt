// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigSpreadsheetRowExpiry : Sig
{
  val remainingInvisibleProgressPercentage: Long?
  val remainingInvisibleTimeMillis: Long?
  val remainingReadProgressPercentage: Long?
  val remainingReadTimeMillis: Long?
  val showTimer: Boolean?
}