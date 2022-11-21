package com.odyssey.liftoff.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncrementTrackViewsResponse {

  private final int code;

  private final boolean success;

  private final String message;

  private final Track track;
}
