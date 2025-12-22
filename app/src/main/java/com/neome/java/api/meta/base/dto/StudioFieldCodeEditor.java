// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCodeEditorLanguage;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldCodeEditor extends StudioFieldParagraph
{
  @Nullable
  public Boolean enableLineNumbers;

  @Nullable
  public Boolean enableMiniMap;

  @Nullable
  public EnumDefnCodeEditorLanguage language;

  @Nullable
  public Boolean showExpandBtn;

  @Nullable
  public String title;
}
