package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackIdNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track)throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();

    public Track updateTrack(Track track) throws TrackIdNotFoundException;

    public boolean deleteTrack(int id) throws TrackIdNotFoundException;




}