// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaId;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldEditable extends StudioField
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
  public StudioValueVarIdText helperTextVarId;

  @Nullable
  public Boolean hideLabel;

  @Nullable
  public String icon;

  @Nullable
  public MetaIdVar iconVarId;

  @Nullable
  public MetaIdField labelFieldId;

  @Nullable
  public String placeHolder;

  @Nullable
  public MetaIdField placeHolderFieldId;

  @Nullable
  public StudioValueVarIdText placeHolderVarId;

  @Nullable
  public String prefix;

  @Nullable
  public StudioValueVarIdText prefixVarId;

  @Nullable
  public MetaIdField refFieldId;

  @Nullable
  public MetaId refTargetId;

  @Nullable
  public Boolean required;

  @Nullable
  public MetaIdField requiredFieldId;

  @Nullable
  public MetaIdRole[] requiredRoleIdSet;

  @Nullable
  public MetaIdVar requiredVarId;

  @Nullable
  public String suffix;

  @Nullable
  public StudioValueVarIdText suffixVarId;
}
