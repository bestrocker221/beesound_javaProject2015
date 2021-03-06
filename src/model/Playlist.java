package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * This class model a playlist in the music library. 
 */
public class Playlist implements Serializable {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 3936662649329388172L;
    private final String name;
    private List<Song> trackList;
    private final String path;

    /**
     * Constructor with two parameters: the name of the playlist to create and its path in the file system.
     * @param name 
     * @param path 
     */
    public Playlist(final String name, final String path) {
        this.name = name;
        this.trackList = new LinkedList<>();
        this.path = path;
    }

    /**
     * The reproduction list for this library. 
     */
    public static class Playing extends Playlist {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private Song songInReproduction;

        Playing() {
            super("IN_REPRODUCTION", "empty"); 
        }

        /**
         * Sets the specified song as song in reproduction. 
         * @param song - the song to set as song in reproduction
         */
        public void setSongInReproduction(final Song song) {
            this.songInReproduction = song;
        }

        /**
         * Returns the song in reproduction.
         * @return the song in reproduction
         */
        public Song getSongInReproduction() {
            return this.songInReproduction;
        }

        /**
         * Sets the specified tracklist as tracklist in the playlist in reproduction. 
         * @param tracklist - the tracklist to set
         */
        public void setTracklist(final List<Song> tracklist) {
            super.trackList = tracklist;
        }
    }

    /**
     * Returns the path in which the playlist is stored.
     * @return the path in which the playlist is stored.
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Returns the name of this playlist.
     * @return the name of this playlist.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the list of the songs in this playlist.
     * @return the list of the songs in this playlist.
     */
    public List<Song> getTrackList() {
        return this.trackList;
    }

    /**
     * Adds a song to this playlist.
     * @param song - the song to add to the playlist.
     */
    public void addSong(final Song song) {
        this.trackList.add(song);
    }

    /**
     * Removes a song from this playlist.
     * @param song - the song to remove from this playlist.
     */
    public void removeSong(final Song song) {
        this.trackList.remove(song);
    }
}
