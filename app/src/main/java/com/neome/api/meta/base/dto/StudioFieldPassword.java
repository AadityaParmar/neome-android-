// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldPassword extends StudioFieldEditableText
{
  @Nullable
  public Long maxCharCount;

  @Nullable
  public MetaIdField maxCharCountFieldId;

  @Nullable
  public MetaIdVar maxCharCountVarId;

  @Nullable
  public Long minCharCount;

  @Nullable
  public MetaIdField minCharCountFieldId;

  @Nullable
  public MetaIdVar minCharCountVarId;

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
