package com.odyssey.liftoff.domain;

import lombok.Data;

@Data
public class Module {

  private final String id;

  private final String title;

  private final String trackId;

  private final String authorId;

  private final String topic;

  private final int length;

  private final String content;

  private final String videoUrl;
}
