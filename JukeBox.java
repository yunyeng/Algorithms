import java.util.ArrayList;
import java.util.Random;
import java.io.*;
class JukeBox<Item> {
	
	class Song<Item>{
		String name;
		String artist;
		String album;
		String genre;
		Song next;
		Song prev;
		boolean playing;
		public Song(String name, String artist, String album, String genre){
			this.name = name;
			this.artist = artist;
			this.album = album;
			this.genre = genre;
		}
	}
	public int current = 0;
	public ArrayList<Song> songList = new ArrayList<Song>();
	public int count = 0;
	public Song currentSong;
	
	public JukeBox(){
		
	}
	public boolean isEmpty(){
		return count == 0;
	}
	public void addSong(String name, String artist, String album, String genre){
		Song s = new Song(name, artist, album, genre);
		songList.add(s);
		if(count < songList.size()) count++;
	}
	public void removeSong(Song s){
		songList.remove(s);
		if(count > 0) count--;
	}
	public void removeSong(int index){
		songList.remove(index);
		if(count > 0) count--;
	}
	public void shuffle(){
		pause();
		Random r = new Random();
		current = r.nextInt(count);
		play();
		/*mode =  mode.toLowerCase();
		if(mode == "shuffle"){
		
		} else if(mode == "repeat"){
			
		} else {
			
		}*/
	}
	public void next(){
		pause();
		current++;
		play();
	}
	public void previous(){
		pause();
		current--;
		play();
	}
	public void pause(){
		currentSong.playing = false;
		System.out.println("JukeBox is paused...");
	}
	public void stop(){
		this.pause();
		this.current = 0;
		this.currentSong = songList.get(current);
		System.out.println("JukeBox is stopped.");
	}
	public void play(){
		currentSong = songList.get(current);
		currentSong.playing = true;
		System.out.println(currentSong.name + " is playing...");
	}
	
	public static void main(String[] args) {
		JukeBox j = new JukeBox();
		j.addSong("Put Your Lights On", "Santana", "Supernatural", "Rock");
		j.play();
		j.stop();
	}
}