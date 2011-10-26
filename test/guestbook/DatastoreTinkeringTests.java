package guestbook;

import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


public class DatastoreTinkeringTests {

	private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	
    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }
	@Test
	public void readTest() {
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        assertEquals(0, ds.prepare(new Query("mike")).countEntities(withLimit(10)));

        Key guestbookKey = KeyFactory.createKey("Guestbook", "mike");
        String usr = "mmich826";
        String content = "sample content";
        Date date = new Date();
        Entity greeting = new Entity("Greeting", guestbookKey);
        //Entity greeting = new Entity("Greeting");
        greeting.setProperty("user", usr);
        greeting.setProperty("date", date);
        greeting.setProperty("content", content);
        ds.put(greeting);
        
        assertEquals(1, ds.prepare(new Query("Greeting")).countEntities(withLimit(10)));
        try {
			assertEquals(1, ds.get(guestbookKey));
			ds.delete(guestbookKey);
			assertEquals(0, ds.get(guestbookKey));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	@Test
	public void queryTest() {
        Key guestbookKey = KeyFactory.createKey("Guestbook", "test");
        String usr = "mmich826";
        Date date = new Date();
        Entity greeting = new Entity("Greeting", guestbookKey);
        greeting.setProperty("user", usr);
        greeting.setProperty("date", date);
        ds.put(greeting);
        
	    Query query = new Query("Greeting", guestbookKey).addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> greetings = ds.prepare(query).asList(FetchOptions.Builder.withLimit(5));
	   	for (Entity gr : greetings) {
	        System.out.print(greeting.getProperty("user"));
	    }
	}

	@Test
	public void createEntityTest() {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        assertEquals(0, ds.prepare(new Query("mike")).countEntities(withLimit(10)));

        Key guestbookKey = KeyFactory.createKey("Guestbook", "mike");
        String usr = "mmich826";
        String content = "sample content";
        Date date = new Date();
        Entity greeting = new Entity("Greeting", guestbookKey);
        //Entity greeting = new Entity("Greeting");
        greeting.setProperty("user", usr);
        greeting.setProperty("date", date);
        greeting.setProperty("content", content);
        ds.put(greeting);
        
        usr = "zeto";
        content = "sample content";
        date = new Date(4123412342134L);
        ds.put(greeting);
        assertEquals(2, ds.prepare(new Query("Greeting")).countEntities(withLimit(10)));
        //assertEquals(2, ds.prepare(new Query("Greeting")));
        try {
			assertEquals(1, ds.get(guestbookKey));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
