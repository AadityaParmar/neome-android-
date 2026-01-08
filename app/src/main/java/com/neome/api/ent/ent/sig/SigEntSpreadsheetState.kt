// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigEntSpreadsheetState : Sig
{
  val gridRemoveVer: String
  val gridVer: String
  val rowCountVer: String
  val rowOrderVer: String
  val sheetIdHash: String
}