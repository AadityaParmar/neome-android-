// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldParagraph extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public DefnDtoParagraph defaultVar;

  @Nullable
  public Boolean flexHeight;

  @Nullable
  public Long lineCount;

  @Nullable
  public MetaIdField lineCountFieldId;

  @Nullable
  public Long lineCountVar;

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
}
