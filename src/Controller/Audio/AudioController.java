package Controller.Audio;

import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Controller.Files.Log;
import javazoom.jlgui.basicplayer.*;

public class AudioController implements BasicPlayerListener{
    
    private List<String> playlist;
    final private BasicPlayer player;
    final private BasicController control;
  //final private Random rnd = new Random();
    private int counter = 0;
    final private  PrintStream out ;
    final private MpegInfo mp3Info;
    
    public AudioController(){
        
        this.player = new BasicPlayer();
        this.control = (BasicController) player;
        this.player.addBasicPlayerListener(this);
        this.out = System.out;
        this.mp3Info = new MpegInfo();
    }
    
    public MpegInfo getMpegInfo(){
        return this.mp3Info;
    }
    public void setPlaylist(final List<String> playlist){
        this.playlist = playlist;
        Log.INFO("New playlist set");
    }
    
    public void addSongInPlaylist(final String song){
        this.playlist.add(song);
        Log.INFO(song +" added to current playlist");
        
    }
    public List<String> getPlaylist(){
        return this.playlist;
    }
    
    public void seek(final int nbytes){
        try {
            this.control.seek(nbytes);
        } catch (BasicPlayerException e) {
            Log.ERROR("Error seeking song");
        }
    }
    public void play(){
        try {
            //System.out.println("canzone: "+this.playlist.get(this.counter));
            this.control.open(new File(this.playlist.get(this.counter)));
            this.control.play();
            this.control.setGain(0.85);
            this.control.setPan(0.0);
            
        } catch ( Exception e){
            e.printStackTrace();
        }
    }
    
    private void linearReproducing(){
        ++this.counter;
        this.play();
    }
    /*
    private void shuffleReproducing(){
        this.counter = rnd.nextInt(this.playlist.size()-1);
        this.play();
    }*/
    
    
    private void display(final String msg) {
        if (out != null) out.println(msg);
    }
    
    @SuppressWarnings("rawtypes")
    @Override
    public void opened(final Object stream,final Map properties) {
            
            display("opened : "+properties.toString());             
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    public void progress(final int bytesread,final long microseconds,
            final byte[] pcmdata,final Map properties) {
            
     //       display("progress : "+properties.toString());
    }
    
    @Override
    public void stateUpdated(final BasicPlayerEvent event) {
            // Notification of BasicPlayer states (opened, playing, end of media, ...)
            display("stateUpdated : "+event.toString());
            if (event.getCode()==BasicPlayerEvent.EOM) {
                    linearReproducing();
            }
    }
    
    @Override
    public void setController(final BasicController controller) {
        display("setController : "+controller);
    }
}
