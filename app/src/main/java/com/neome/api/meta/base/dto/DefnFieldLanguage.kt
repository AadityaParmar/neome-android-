// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldLanguage : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: LanguageKey?
  val defaultVar: LanguageKey?
}