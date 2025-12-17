// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MediaIdJar;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoJarFile;

@SuppressWarnings("unused")
public class StudioMapOfJarFile extends StudioBase
{
  public MediaIdJar[] keys;

  public Map<MediaIdJar, StudioDtoJarFile> map;
}
