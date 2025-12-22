// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdExpertPause extends EntVdAutoStep
{
  @Nullable
  public Boolean canAdminResume;

  @Nullable
  public StudioValueParagraph message;

  @Nullable
  public MetaIdVar option;

  @Nullable
  public StudioValueText pauseKey;
}
