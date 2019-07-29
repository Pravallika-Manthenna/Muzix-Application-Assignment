package com.stackroute.MuzixAppMysql.service;

import com.stackroute.MuzixAppMysql.domain.Track;
import com.stackroute.MuzixAppMysql.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixAppMysql.exceptions.TrackNotFoundException;
import java.util.List;

//track service interface 
//method declarations are done in this
public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks();

    public List<Track> getTracksByName(String name);

    public Track updateTrack(Track track, int id) throws TrackNotFoundException;

    public boolean deleteTrack(int id) throws TrackNotFoundException;

    public List<Track> searchTracks(String searchString);
}
