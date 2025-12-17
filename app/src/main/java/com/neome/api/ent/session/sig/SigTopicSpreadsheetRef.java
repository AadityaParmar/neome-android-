// neome.ai API - do not change
//

package com.neome.api.ent.session.sig;

import com.neome.api.core.session.sig.SigTopic;
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef;
import com.neome.api.meta.base.Types.RowId;

@SuppressWarnings("unused")
public class SigTopicSpreadsheetRef extends SigTopic
{
  public MetaIdSpreadsheetRef metaIdSpreadsheetRef;

  public RowId targetRowId;
}
