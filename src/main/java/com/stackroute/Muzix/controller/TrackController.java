package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.Muzix.repository.TrackRepository;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class TrackController {
    TrackRepository trackRepository;
    TrackService trackService;
    ResponseEntity responseEntity;
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }    @PostMapping("track")
    public ResponseEntity<?> saveTracks(@RequestBody Track track) throws TrackAlreadyExistsException
    {

            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks()
    {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackIdNotFoundException {
        trackService.updateTrack(track);
        responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.CREATED);


        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) throws TrackIdNotFoundException {

            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
               return responseEntity;
    }
}


