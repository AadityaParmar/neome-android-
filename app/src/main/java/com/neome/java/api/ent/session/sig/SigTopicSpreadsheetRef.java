// neome.ai API - do not change
//

package com.neome.java.api.ent.session.sig;

import com.neome.java.api.core.session.sig.SigTopic;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheetRef;
import com.neome.java.api.meta.base.Types.RowId;

@SuppressWarnings("unused")
public class SigTopicSpreadsheetRef extends SigTopic
{
  public MetaIdSpreadsheetRef metaIdSpreadsheetRef;

  public RowId targetRowId;
}
