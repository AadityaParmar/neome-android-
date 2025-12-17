// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldEditable extends DefnField
{
  @Nullable
  public Boolean autoFill;

  @Nullable
  public Boolean autoFocus;

  @Nullable
  public String helperText;

  @Nullable
  public MetaIdField helperTextFieldId;

  @Nullable
  public DefnDtoText helperTextVar;

  @Nullable
  public Boolean hideLabel;

  @Nullable
  public String icon;

  @Nullable
  public String iconVar;

  @Nullable
  public MetaIdField labelFieldId;

  @Nullable
  public String placeHolder;

  @Nullable
  public MetaIdField placeHolderFieldId;

  @Nullable
  public DefnDtoText placeHolderVar;

  @Nullable
  public String prefix;

  @Nullable
  public DefnDtoText prefixVar;

  @Nullable
  public Boolean required;

  @Nullable
  public MetaIdField requiredFieldId;

  @Nullable
  public MetaIdRole[] requiredRoleIdSet;

  @Nullable
  public Boolean requiredVar;

  @Nullable
  public String suffix;

  @Nullable
  public DefnDtoText suffixVar;
}
