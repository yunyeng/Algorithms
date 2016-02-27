import java.util.*;
class JukeBoxx {
	private class Song {
		private int id;
		private String name;
		private String album;
		private String artist;
		private 	int year;
		public Song(int i, String n, String alb, String art, int y){
			id     = i;
			name   = n;
			album  = alb;
			artist = art;
			year   = y;
		}
		public void display(){
			System.out.print("Id: " + id);
			System.out.print(" Name: " + name);
			System.out.print(" Album: " + album);
			System.out.print(" Artist: " + artist);
			System.out.print(" Year: " + year);
			System.out.println();
		}
	}
	List<Song> songs;
	int size;
	Song prev;
	Song current;
	public JukeBoxx(){
		songs = new ArrayList<>();
		size = 0;
		prev = null;
		current = null;
	}
	public void addSong(String name, String album, String artist, int year){
		Song song = new Song(size+1, name, album, artist, year);
		songs.add(song);
		size++;
	}
	public void getByArtist(String artist){
		artist = artist.toLowerCase();
		for(Song song : songs)
			if(song.artist.toLowerCase().equals(artist))
				song.display();
	}
	public void getByAlbum(String album){
		album = album.toLowerCase();
		for(Song song : songs)
			if(song.album.toLowerCase().equals(album))
				song.display();
	}
	public void getByYear(int year){
		for(Song song : songs)
			if(song.year == year)
				song.display();
	}
	public void select(int id){
		prev = current;
		current = songs.get(id-1);
		current.play();
	}
	public void shuffle(){
		current = Math.random(0, size);
	}
	public void stop(){
		
	}
	
	public static void main(String[] args) {
		
	}
}