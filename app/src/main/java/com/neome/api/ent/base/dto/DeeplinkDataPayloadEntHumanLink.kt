// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.dto.FormValueRaw

interface DeeplinkDataPayloadEntHumanLink : DeeplinkDataPayloadEnt
{
  val embedFormDefn: DefnForm
  val embedFormValue: FormValueRaw?
  val entId: EntId
  val message: String
  val senderHandle: String?
  val senderName: String?
  val targetHandle: String?
  val targetName: String?
  val title: String
}