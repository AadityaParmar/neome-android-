// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldText extends StudioFieldEditableText
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
  public StudioDtoTextValidationPattern validationPattern;
}
