// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldPassword extends DefnFieldEditableText
{
  @Nullable
  public Long maxCharCount;

  @Nullable
  public MetaIdField maxCharCountFieldId;

  @Nullable
  public Long maxCharCountVar;

  @Nullable
  public Long minCharCount;

  @Nullable
  public MetaIdField minCharCountFieldId;

  @Nullable
  public Long minCharCountVar;

  @Nullable
  public Boolean requireLowerCaseChar;

  @Nullable
  public Boolean requireNumericChar;

  @Nullable
  public Boolean requireSpecialChar;

  @Nullable
  public Boolean requireUpperCaseChar;

  @Nullable
  public Boolean securePassword;
}
