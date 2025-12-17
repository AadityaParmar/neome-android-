// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.GhostId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdPrompt extends StudioBase
{
  public GhostId metaId;

  @Nullable
  public StudioValueCodeJavascript prompt;

  @Nullable
  public FormRefKey promptForm;
}
