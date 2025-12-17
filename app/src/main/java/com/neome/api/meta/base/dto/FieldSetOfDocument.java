// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnDocFileExt;
import com.neome.api.meta.base.Types.MediaIdDocument;

@SuppressWarnings("unused")
public class FieldSetOfDocument
{
  public EnumDefnDocFileExt[] fileExtSet;

  public String[] fileNameSet;

  public long[] fileSizeSet;

  public MediaIdDocument[] mediaIdDocumentSet;
}