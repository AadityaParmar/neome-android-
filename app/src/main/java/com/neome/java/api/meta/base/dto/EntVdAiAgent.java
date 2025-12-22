// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAiAgent extends EntVdAiWithOutput
{
  @Nullable
  public EntVdAiAgentControlMap agentControlMap;

  @Nullable
  public FormRefKey outputForm;

  @Nullable
  public StudioValueParagraph systemMessage;

  @Nullable
  public StudioValueParagraph userMessage;
}
