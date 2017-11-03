package main;

import api.MovieRecAPI;;

public class Main {

	public static void main(String args[]) {
		int choice;

		MovieRecAPI menu = new MovieRecAPI();
		do {
			choice = menu.menuMain();

			switch (choice) {
			case 1:
				menu.menuAddUser();
				break;
			case 2:
				menu.menuShowUser();
				break;
			case 3:
				menu.showUserList();
				break;
			case 4:
				menu.menuAddMovie();
			case 5:
				menu.menugetMovie();
				break;
			case 6:
				menu.menugetMoviesByTitle();
				break;
			case 7:
				menu.menugetMoviesByYear();
				break;
			case 8:
				menu.writeUsers();
				break;
			case 9:
				menu.writeMovies();
				break;
			default:
				break;
			}
		} while (choice != 10 );

	}
}
