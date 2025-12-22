// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnDocFileExt;
import com.neome.java.api.meta.base.Types.MediaIdDocument;

@SuppressWarnings("unused")
public class FieldSetOfDocument
{
  public EnumDefnDocFileExt[] fileExtSet;

  public String[] fileNameSet;

  public long[] fileSizeSet;

  public MediaIdDocument[] mediaIdDocumentSet;
}
