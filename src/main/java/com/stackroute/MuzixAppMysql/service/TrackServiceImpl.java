package com.stackroute.MuzixAppMysql.service;
//
//import com.stackroute.MuzixAppMysql.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//public class TrackServiceimpl {
//}
//package com.stackroute.MuzixAppMysql.service;
//        import com.stackroute.MuzixAppMysql.domain.User;
//        import com.stackroute.MuzixAppMysql.repository.UserRepository;
//
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//        import java.util.List;
//        import java.util.Optional;
//
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    UserRepository userRepository;
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//
//    }
//
//    @Override
//    public User saveUser(User user) {
//        User savedUser = userRepository.save(user);
//
//        return savedUser;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//
//        return userRepository.findAll();
//    }
//
//
//    public User updateUser(User user, int id) throws Exception {
//        Optional<User> userOptional = userRepository.findById(id);
//
//        if (!userOptional.isPresent())
//            throw new Exception("user id not found");
//
//
//        user.setId(id);
//
//        return userRepository.save(user);
//
//    }
//
//    @Override
//    public boolean deleteuser(int id) throws Exception {
//        Optional<User> userOptional = userRepository.findById(id);
//
//        if (!userOptional.isPresent())
//            throw new Exception("user id not found");
//        userRepository.delete(userOptional.get());
//        return true;
//    }
//
//    @Override
//    public List<User> searchUser(String searchString) {
//        return userRepository.searchUser(searchString);
//    }
//
//    @Override
//    public List<User> getUserByName(String name) {
//
//        return userRepository.getUserByName(name);
//
//        @Override
//        public boolean deleteuser ( int id) throws Exception {
//            Optional<User> userOptional = userRepository.findById(id);
//
//            if (!userOptional.isPresent())
//                throw new Exception("user id not found");
//            userRepository.delete(userOptional.get());
//            return true;
//        }
//
//        @Override
//        public List<User> searchUser (String searchString){
//            return userRepository.searchUser(searchString);
//        }

//            @Override
//    public List<User> searchUser(String name, int id) {
//        System.out.println(name);
//        System.out.println(id);
//        return userRepository.searchUser(name,id);
//  }
//
//
//    }
//}

import com.stackroute.MuzixAppMysql.domain.Track;
import com.stackroute.MuzixAppMysql.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixAppMysql.exceptions.TrackNotFoundException;
import com.stackroute.MuzixAppMysql.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack = trackRepository.save(track);

        if(savedTrack == null)
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {

        return trackRepository.findAll();
    }

    @Override
    public List<Track> getTracksByName(String name) {

        return trackRepository.getTrackByName(name);

    }

    public Track updateTrack(Track track, int id) throws TrackNotFoundException
    {
        Optional<Track> track1 = trackRepository.findById(id);

        if(!track1.isPresent())
        {
            throw new TrackNotFoundException("Track Not Found");
        }

        track.setId(id);

        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    public boolean deleteTrack(int id) throws TrackNotFoundException
    {
        Optional<Track> track1 = trackRepository.findById(id);

        if(!track1.isPresent())
        {
            throw new TrackNotFoundException("Track Not Found");
        }

        try {

            trackRepository.delete(track1.get());

            return true;

        }
        catch (Exception exception)
        {
            return false;
        }
    }

    @Override
    public List<Track> searchTracks(String searchString) {

        return trackRepository.searchTracks(searchString);
    }
}