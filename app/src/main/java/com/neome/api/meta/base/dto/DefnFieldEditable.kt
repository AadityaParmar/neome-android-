// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

interface DefnFieldEditable : DefnField
{
  val autoFill: Boolean?
  val autoFocus: Boolean?
  val helperText: String?
  val helperTextFieldId: MetaIdField?
  val helperTextVar: DefnDtoText?
  val hideLabel: Boolean?
  val icon: String?
  val iconVar: String?
  val labelFieldId: MetaIdField?
  val placeHolder: String?
  val placeHolderFieldId: MetaIdField?
  val placeHolderVar: DefnDtoText?
  val prefix: String?
  val prefixVar: DefnDtoText?
  val required: Boolean?
  val requiredFieldId: MetaIdField?
  val requiredRoleIdSet: List<MetaIdRole>?
  val requiredVar: Boolean?
  val suffix: String?
  val suffixVar: DefnDtoText?
}