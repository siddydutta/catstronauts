package com.odyssey.liftoff.controller;

import com.odyssey.liftoff.domain.Author;
import com.odyssey.liftoff.domain.IncrementTrackViewsResponse;
import com.odyssey.liftoff.domain.Module;
import com.odyssey.liftoff.domain.Track;
import com.odyssey.liftoff.service.CatstronautsService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TrackController {

  private final CatstronautsService service;

  @QueryMapping
  public List<Track> tracksForHome() {
    return service.getAllTracks();
  }

  @SchemaMapping
  public Author author(Track track) {
    return service.getAuthor(track.getAuthorId());
  }

  @SchemaMapping
  public List<Module> modules(Track track) {
    return service.getTrackModules(track.getId());
  }

  @QueryMapping
  public Track track(@Argument String id) {
    return service.getTrack(id);
  }

  @QueryMapping
  public Module module(@Argument String id) {
    return service.getModule(id);
  }

  @MutationMapping
  public IncrementTrackViewsResponse incrementTrackViews(@Argument String id) {
    return service.incrementViewForTrack(id);
  }
}
