package com.stackroute.MuzixAppMysql.repository;

import com.stackroute.MuzixAppMysql.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

//repository annotation is used to identify that this is a repository
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

    //query for getting tracks by name
    @Query("SELECT t FROM Track t WHERE name = ?1")
    List<Track> getTrackByName(String name);

    //query for search tracks
    @Query(value = "SELECT t FROM Track t WHERE name = ?1 OR artist = ?1")
    List<Track> searchTracks(String searchString);
}
