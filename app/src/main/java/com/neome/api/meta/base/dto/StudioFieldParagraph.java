// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldParagraph extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public StudioValueVarIdParagraph defaultVarId;

  @Nullable
  public Boolean flexHeight;

  @Nullable
  public Long lineCount;

  @Nullable
  public MetaIdField lineCountFieldId;

  @Nullable
  public MetaIdVar lineCountVarId;

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
}
