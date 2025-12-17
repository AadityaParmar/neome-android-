// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldText extends DefnFieldEditableText
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
  public DefnDtoTextValidationPattern validationPattern;
}
