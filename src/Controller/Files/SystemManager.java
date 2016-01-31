package Controller.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface SystemManager {
    
    /**
     * Return a list of string representing the absolute path of every playlist.
     * @return a List<String>
     */
    List<String> listAllPlaylist();
    
    /**
     * Return a list of string representing the absolute path of every mp3 song in the default Music directory
     * @return a List<String>
     */
    List<String> listAllSongPath();
    
    /**
     * Import the given mp3 into the library.
     * @param pathSource
     * @return final path of the copied file.
     */
    String importToLibrary(final String mp3Source);
    
    /**
     * Return a List of every song's absolute path contained in the given playlist 
     * @param playlist
     * @return
     * @throws IOException
     */
    List<String> getPlaylistSongs(final File playlist) throws IOException;
    
    /**
     * Return true if is already existing in the library.
     * @return boolean
     */
    boolean notExist(final String srcPath);
    
    /**
     * Create a new text file with the given name in the dstPath
     * Note: dstPath must have final "/"
     * @param dstPath, name
     */
    void createNewFile(final String name,final String dstPath);
    
    /**
     * Delete the selected file.
     * @param pathFile
     */
    void delete(final String pathFile);
    
    /**
     * Append a message to the file pointed.
     * @param msg
     * @param path
     */
    public void appendToFile(final String msg, final String path);
}
