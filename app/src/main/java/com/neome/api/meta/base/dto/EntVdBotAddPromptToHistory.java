// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdBotAddPromptToHistory extends EntVdAutoStep
{
  @Nullable
  public StudioDtoArgValueParameter documentAttachment;

  @Nullable
  public StudioDtoArgValueParameter imageAttachment;

  @Nullable
  public StudioBuildArgBinder label;

  @Nullable
  public StudioDtoArgValueParameter promptField;
}
