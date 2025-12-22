// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

@SuppressWarnings("unused")
public class DeeplinkDataPayloadEntSpreadsheetEditorShare extends DeeplinkDataPayloadEnt
{
  public EntId entId;

  public MetaIdLayoutGrid layoutSpreadsheetId;

  public MetaIdAction metaIdAction;

  public MetaIdSpreadsheet metaIdSpreadsheet;
}
