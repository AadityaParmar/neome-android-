// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.dto.DtoGridLayoutRefKey;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.meta.base.dto.GsonCto;

@SuppressWarnings("unused")
public class DtoEntFormExportExcel extends GsonCto
{
  public MetaIdForm formId;

  public FormValueRaw formValueRaw;

  public DtoGridLayoutRefKey[] layoutRefKeyList;
}
