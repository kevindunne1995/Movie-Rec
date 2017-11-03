package api;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import users.Movies;
import users.Users;

public class MovieRecAPI {

	private static Icon myIcon = new ImageIcon("board.jpg");
	private static Icon anIcon = new ImageIcon("roll1.jpg");
	private String title = "Movies";
	
	
	File fileName = new File ("Users.dat");
	private ArrayList<Users> UserList = new ArrayList<Users>();
	File fileNameM = new File ("Movies.dat");
	private ArrayList<Movies> MovieList = new ArrayList<Movies>();

	public MovieRecAPI() {
		
		Users user = new Users("01", "Kevin", "Dunne", "21" ,"M", "Technician", "23423");
		addUserToList(user);
		
		Movies movie = new Movies ("01","Jon Wick","2014");
		addMovieToList(movie);
	}
	
	
	public void showUserList() {
		Users[] tempList = new Users[UserList.size()];
		for (int i=0; i<UserList.size(); i++){
			tempList[i] = UserList.get(i);
		}
		
		JList<?> jList = new JList<Object>(tempList);
		
		JOptionPane.showConfirmDialog(null, jList, title, JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, anIcon);
	}

	public int menuMain() {
		int option = 0;

		String opt1 = new String("1. Add a User's Details :");
		String opt2 = new String("2. Show User's Details :");
		String opt3 = new String("3. List All User's Details :");
		String opt4 = new String("4. Add Movies Details :");
		String opt5 = new String("5. Get Movie Details :");
		String opt6 = new String("6. Get Movie by Title :");
		String opt7 = new String("7. Get Movie by Release Year :");
		String opt8 = new String("8. Write Users List to file :");
		String opt9 = new String("9. Write Movies List to file :");
		String opt10 = new String("10. Exit :");
		String msg = new String("Enter Option:");
		JTextField opt = new JTextField("");

		Object message[] = new Object[13];

		message[0] = myIcon;
		message[1] = opt1;
		message[2] = opt2;
		message[3] = opt3;
		message[4] = opt4;
		message[5] = opt5;
		message[6] = opt6;
		message[7] = opt7;
		message[8] = opt8;
		message[9] = opt9;
		message[10] = opt10;
		message[11] = msg;
		message[12] = opt;

		int response = JOptionPane.showConfirmDialog(null, message, title , JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, anIcon);

		if (response == JOptionPane.CANCEL_OPTION)
			;
		else {
			try {
				option = Integer.parseInt(opt.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e + "\nPlease Try Again");
			}
		}
		return option;
	}
	
	///////////////////////

	public void menugetMoviesByTitle() {
		String msgTxtID = "Please Enter the Title of the Movie you wish to view.";
		JTextField txtID = new JTextField("");

		Object[] message = new Object[3];

		message[0] = myIcon;
		message[1] = msgTxtID;
		message[2] = txtID;

		JOptionPane.showMessageDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);
		int i = searchMovie(txtID.getText());

		if (i == -1)
			JOptionPane.showMessageDialog(null, "Sorry, Movie Does Not Exist..");
		else
			JOptionPane.showMessageDialog(null, MovieList.get(i));
	}

	private int searchMovie(String MovieName) {
		for (int i = 0; i < MovieList.size(); i++) {
			if (MovieList.get(i).getMovieName().equals(MovieName)) {
				return i;
			}
		}
		return -1;
	}
	
	////////////////////
	
	
	public void menugetMoviesByYear() {
		String msgTxtID = "Please Enter the year released of the Movie you wish to view.";
		JTextField txtID = new JTextField("");

		Object[] message = new Object[3];

		message[0] = myIcon;
		message[1] = msgTxtID;
		message[2] = txtID;

		JOptionPane.showMessageDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);
		int i = searchMoviedate(txtID.getText());

		if (i == -1)
			JOptionPane.showMessageDialog(null, "Sorry, Movie could not be found..");
		else
			JOptionPane.showMessageDialog(null, MovieList.get(i));
	}

	private int searchMoviedate(String ReleaseDate) {
		for (int i = 0; i < MovieList.size(); i++) {
			if (MovieList.get(i).getMovieName().equals(ReleaseDate)) {
				return i;
			}
		}
		return -1;
	}
	
	
	////////////////////////////////////////////
	
	public void menuShowUser() {
		String msgTxtID = "Please Enter the ID of the User you wish to view.";
		JTextField txtID = new JTextField("");

		Object[] message = new Object[3];

		message[0] = myIcon;
		message[1] = msgTxtID;
		message[2] = txtID;

		JOptionPane.showMessageDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);
		int i = searchUser(txtID.getText());

		if (i == -1)
			JOptionPane.showMessageDialog(null, "Sorry, ID Does Not Exist..");
		else
			JOptionPane.showMessageDialog(null, UserList.get(i));
	}

	private int searchUser(String id) {
		for (int i = 0; i < UserList.size(); i++) {
			if (UserList.get(i).getUserId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
/////////////////////////////////////////////////////////////
	
	
	public void menugetMovie() {
		String msgTxtID = "Please Enter the ID of the Movie you wish to view.";
		JTextField txtID = new JTextField("");

		Object[] message = new Object[3];

		message[0] = myIcon;
		message[1] = msgTxtID;
		message[2] = txtID;

		JOptionPane.showMessageDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);
		int i = searchMovieID(txtID.getText());

		if (i == -1)
			JOptionPane.showMessageDialog(null, "Sorry, ID Does Not Exist..");
		else
			JOptionPane.showMessageDialog(null, MovieList.get(i));
	}

	private int searchMovieID(String MovieID) {
		for (int i = 0; i < UserList.size(); i++) {
			if (MovieList.get(i).getMovieId().equals(MovieID)) {
				return i;
			}
		}
		return -1;
	}
	
	
/////////////////////////////////////////////////////////////

	public void writeUsers() {
		try {
			FileWriter fw = new FileWriter(fileName);
			Writer output = new BufferedWriter(fw);
			int sz = UserList.size();
			for (int i = 0; i < sz; i++) {
				output.write(UserList.get(i).toString() + "\n");
			}
			output.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "I cannont create that file");
		}
	}
	
	
///////////////////////////////////////////////////////////////
	
	public void writeMovies() {
		try {
			FileWriter fw = new FileWriter(fileNameM);
			Writer output = new BufferedWriter(fw);
			int sz = MovieList.size();
			for (int i = 0; i < sz; i++) {
				output.write(MovieList.get(i).toString() + "\n");
			}
			output.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "I cannont create that file");
		}
	}
	
	
	
///////////////////////////////////////////////////////////////

	private void addUserToList(Users user) {
		UserList.add(user);
	}
	
	private void addMovieToList(Movies movie) {
		MovieList.add(movie);
	}

	public void menuAddUser() {

		String msguserId = "Please enter User id number here";
		JTextField UserID = new JTextField("");
		String msgfname = "Please enter User first name here";
		JTextField UserFName = new JTextField("");
		String msglname = "Please enter User last name here";
		JTextField UserLName = new JTextField("");
		String msgage = "Please enter User age here";
		JTextField Age = new JTextField("");
		String msggender = "Please enter User Gender here";
		JTextField Gender = new JTextField("");
		String msgoccupation = "Please enter User Occupation here";
		JTextField Occupation = new JTextField("");
		String msgnum = "Please enter User number here";
		JTextField num = new JTextField("");


		Object message[] = new Object[15];

		message[0] = myIcon;
		message[1] = msguserId;
		message[2] = UserID;
		message[3] = msgfname;
		message[4] = UserFName;
		message[5] = msglname;
		message[6] = UserLName;
		message[7] = msgage;
		message[8] = Age;
		message[9] = msggender;
		message[10] = Gender;
		message[11] = msgoccupation;
		message[12] = Occupation;
		message[13] = msgnum;
		message[14] = num;




		int response = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

		if (response == JOptionPane.CANCEL_OPTION)
			;
		else {
			try {

				Users user = new Users(UserID.getText(), UserFName.getText(), UserLName.getText(), Age.getText(),Gender.getText(), Occupation.getText(), num.getText() );
				addUserToList(user);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e + "\nPlease Try Again");
			}
		}

	}
	
	
	public void menuAddMovie() {

		String msgmovieid = "Please enter Movie id here";
		JTextField MovieID = new JTextField("");
		String msgmoviename = "Please enter Movie Title here";
		JTextField MovieName = new JTextField("");
		String msgrelease = "Please enter Movie Release Date here";
		JTextField ReleaseDate = new JTextField("");



		Object message[] = new Object[7];

		message[0] = myIcon;
		message[1] = msgmovieid;
		message[2] = MovieID;
		message[3] = msgmoviename;
		message[4] = MovieName;
		message[5] = msgrelease;
		message[6] = ReleaseDate;





		int response = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

		if (response == JOptionPane.CANCEL_OPTION)
			;
		else {
			try {

				Movies movie = new Movies(MovieID.getText(), MovieName.getText(), ReleaseDate.getText());
				addMovieToList(movie);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e + "\nPlease Try Again");
			}
		}

	}

}