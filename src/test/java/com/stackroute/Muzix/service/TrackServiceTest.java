package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {

    private Track track;

    //Create a mock for UserRepositoryTest
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setName("John");
        track.setId(101);
        track.setComment("Jenny");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveUserTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedUser = trackService.saveTrack(track);
        System.out.println("savedUser" + savedUser);
        Assert.assertEquals(track,savedUser);

     /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
     userService.saveUser(user);*/


    }

    @Test
    public void getAllTrack(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }





}