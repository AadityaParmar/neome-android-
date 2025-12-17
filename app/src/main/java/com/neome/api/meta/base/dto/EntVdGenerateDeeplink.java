// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdDeeplink;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdGenerateDeeplink extends EntVdAutoStep
{
  @Nullable
  public MetaIdDeeplink deeplinkId;

  @Nullable
  public StudioDtoArgValueParameter outputField;

  @Nullable
  public MetaIdAction spreadsheetEditorActionId;
}
