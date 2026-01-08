// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg
import java.util.Set

interface MsgEntUserPickerCandidateListGet : Msg
{
  val formValueRaw: FormValueRaw?
  val roleIdSet: Array<MetaIdRole>?
  val setOfUserVarId: MetaIdVar?
  val sourceFormId: MetaIdForm
}