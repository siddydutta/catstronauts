package com.odyssey.liftoff.domain;

import lombok.Data;

import java.util.List;

@Data
public class Track {

  private final String id;

  private final String thumbnail;

  private final String topic;

  private final String authorId;

  private final String title;

  private final String description;

  private final int numberOfViews;

  private final int numberOfLikes;

  private final String createdAt;

  private final int length;

  private final int modulesCount;

  private final List<String> modules;
}
