// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.SearchPath;

import java.util.Set;

@SuppressWarnings("unused")
public class SearchResult
{
  @Nullable
  public Map<SearchPath, Set<String>> result;
}
