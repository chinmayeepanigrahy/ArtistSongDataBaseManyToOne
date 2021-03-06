/**
 * This file was generated by the Jeddict
 */
package artistsongdatabase.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author chinm
 */
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    

    @Basic
    private String Name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<Song> getSongs() {
        if (songs == null) {
            songs = new ArrayList<>();
        }
        return this.songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        getSongs().add(song);
        song.setArtist(this);
    }

    public void removeSong(Song song) {
        getSongs().remove(song);
        song.setArtist(null);
    }

}