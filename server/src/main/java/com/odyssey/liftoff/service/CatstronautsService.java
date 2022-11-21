package com.odyssey.liftoff.service;

import com.odyssey.liftoff.client.CatstronautsClient;
import com.odyssey.liftoff.domain.Author;
import com.odyssey.liftoff.domain.IncrementTrackViewsResponse;
import com.odyssey.liftoff.domain.Module;
import com.odyssey.liftoff.domain.Track;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CatstronautsService {

  private final CatstronautsClient client;

  public List<Track> getAllTracks() {
    return client.tracks();
  }

  public Author getAuthor(String authorId) {
    return client.authorById(authorId);
  }

  public List<Module> getTrackModules(String trackId) {
    return client.modulesByTrackId(trackId);
  }

  public Track getTrack(String trackId) {
    return client.trackById(trackId);
  }

  public Module getModule(String moduleId) {
    return client.moduleById(moduleId);
  }

  public IncrementTrackViewsResponse incrementViewForTrack(String trackId) {
    try {
      Track track = client.incrementTrackViewById(trackId);
      return IncrementTrackViewsResponse.builder()
          .code(HttpStatus.OK.value())
          .success(true)
          .message(String.format("Successfully incremented number of views for track %s", trackId))
          .track(track)
          .build();
    } catch (FeignException exception) {
      return IncrementTrackViewsResponse.builder()
          .code(exception.status())
          .success(false)
          .message(exception.getMessage())
          .build();
    }
  }
}
