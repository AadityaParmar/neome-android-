// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.home.base.dto.DtoUserAddrBookContact;
import com.neome.java.api.home.base.dto.DtoUserAddrBookOtherContact;
import com.neome.java.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import java.util.Map;

@SuppressWarnings("unused")
public class SigAddressBook extends SigVersion
{
  public Map<AnyPrefixKey, DtoUserAddrBookContact[]> candidateMap;

  public DtoUserAddrBookOtherContact[] othersList;
}
