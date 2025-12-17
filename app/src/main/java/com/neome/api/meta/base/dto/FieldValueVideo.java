// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MediaIdImage;
import com.neome.api.meta.base.Types.MediaIdVideo;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class FieldValueVideo
{
  public long durationMs;

  @Nullable
  public String fileName;

  public MediaIdImage mediaIdBlurImage;

  public MediaIdImage mediaIdImage;

  public MediaIdVideo mediaIdVideo;

  public String primaryColor;

  public long size;
}
