package com.odyssey.liftoff.client;

import com.odyssey.liftoff.domain.Author;
import com.odyssey.liftoff.domain.Module;
import com.odyssey.liftoff.domain.Track;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CatstronautsClient",
    url = "https://odyssey-lift-off-rest-api.herokuapp.com")
public interface CatstronautsClient {

  @GetMapping("/tracks")
  List<Track> tracks();

  @GetMapping("/author/{id}")
  Author authorById(@PathVariable(name = "id") String id);

  @GetMapping("/track/{id}/modules")
  List<Module> modulesByTrackId(@PathVariable(name = "id") String id);

  @GetMapping("/track/{id}")
  Track trackById(@PathVariable(name = "id") String id);

  @GetMapping("/module/{id}")
  Module moduleById(@PathVariable(name = "id") String id);

  @PatchMapping("/track/{id}/numberOfViews")
  Track incrementTrackViewById(@PathVariable(name = "id") String id);
}
