package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import users.Users;

public class UserTest
{
  Users kevin = new Users ("01", "Kevin", "Dunne", "21" ,"M", "Technician", "23423");


@Test
public void testCreate()
{
  assertEquals ("01",               kevin.UserID);
  assertEquals ("Kevin",             kevin.UserFName);
  assertEquals ("Dunne",   kevin.UserLName);   
  assertEquals ("21",              kevin.Age);   
  assertEquals ("M",              kevin.Gender);   
  assertEquals ("Technician",              kevin.Occupation);   
  assertEquals ("23423",              kevin.num);   
}




@Test
public void testEquals()
{
	Users kevin = new Users ("01", "Kevin", "Dunne", "21" ,"M", "Technician", "23423");
	Users jirka   = new Users ("02", "Jirka", "Vyhnalek", "19" ,"M", "Photographer", "43234"); 


  assertEquals(kevin, kevin);
  assertEquals(kevin, kevin);
  assertNotEquals(kevin, jirka);
  assertSame(kevin, kevin);
  assertNotSame(kevin, jirka);
}

}