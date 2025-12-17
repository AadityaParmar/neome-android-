// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.home.base.dto.DtoStarMessage;
import com.neome.api.nucleus.base.sig.SigVersion;

@SuppressWarnings("unused")
public class SigStarMessageList extends SigVersion
{
  public DtoStarMessage[] starMessageList;
}