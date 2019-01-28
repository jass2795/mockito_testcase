package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService
{
    TrackRepository trackRepositroy;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepositroy)
    {
    this.trackRepositroy = trackRepositroy;
    }
@Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
    if(trackRepositroy.existsById(track.getId()))
    {
        throw new TrackAlreadyExistsException("Track already exists");
    }
    Track savedTrack=trackRepositroy.save(track);
    if (savedTrack == null)
    {
        throw new TrackAlreadyExistsException("Track already exists");
    }
    return savedTrack;
}
@Override
public List<Track> getAllTracks()
{
    return trackRepositroy.findAll();
}
@Override
public boolean deleteTrack(int id) throws TrackIdNotFoundException
{
    //return null;
    boolean status=false;
    if(trackRepositroy.existsById(id))
    {
        trackRepositroy.deleteById(id);
        status=true;
        return status;
    }
    else
    {
        throw new TrackIdNotFoundException("Track not found");
    }
}



    @Override
    public Track updateTrack(Track track) throws TrackIdNotFoundException
    {
        if(trackRepositroy.existsById(track.getId()))
        {
            Track updateTrack=trackRepositroy.save(track);
            return updateTrack;
        }
        else
            {            throw new TrackIdNotFoundException("ID doesnt exist");
        }
    }
}