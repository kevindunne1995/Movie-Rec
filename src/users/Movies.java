package users;

public class Movies {
	private String MovieID;
	private String MovieName;
	private String ReleaseDate;
	

	public Movies() {
		this.MovieID = "";
		this.MovieName = "";
		this.ReleaseDate = "";
		
		

	}

	public Movies(String MovieID, String MovieName, String ReleaseDate ) {
		this.MovieID = MovieID;
		this.MovieName = MovieName ;
		this.ReleaseDate = ReleaseDate;
		
	}

	public String getMovieId() {
		return MovieID;
	}
	
	public String getMovieName() {
		return MovieName;
	}
	
	public String getMoviebyYear() {
		return ReleaseDate;
	}
	
	@Override
	public String toString() {
		return "Movies [MovieID=" + MovieID + ", MovieName="+ MovieName +", ReleaseDate=" + ReleaseDate +" ]";
	}

}


