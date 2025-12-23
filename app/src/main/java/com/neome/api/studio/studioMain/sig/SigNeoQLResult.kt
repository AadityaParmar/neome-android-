// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig

open class SigNeoQLResult : Sig()
{
  lateinit var defnForm: DefnForm
  lateinit var formValue: FormValue
  lateinit var formValueLogTree: DtoLogTree
}