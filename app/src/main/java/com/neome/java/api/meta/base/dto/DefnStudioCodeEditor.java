// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCodeEditorLanguage;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioCodeEditor extends DefnFieldParagraph
{
  @Nullable
  public Boolean allowCopy;

  @Nullable
  public DefnStudioDtoCodeEditor autoCompletePayload;

  @Nullable
  public Boolean enableLineNumbers;

  @Nullable
  public Boolean enableMiniMap;

  @Nullable
  public Boolean excludeAiInput;

  @Nullable
  public EnumDefnCodeEditorLanguage language;

  @Nullable
  public Long minHeight;

  @Nullable
  public Boolean showExpandBtn;

  @Nullable
  public String title;
}
