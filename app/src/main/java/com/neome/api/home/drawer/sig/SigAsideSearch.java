// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.home.main.sig.SigMessage;
import com.neome.api.nucleus.base.sig.SigVersion;

@SuppressWarnings("unused")
public class SigAsideSearch extends SigVersion
{
  public SigMessage[] messageList;

  public long totalMessageCount;
}