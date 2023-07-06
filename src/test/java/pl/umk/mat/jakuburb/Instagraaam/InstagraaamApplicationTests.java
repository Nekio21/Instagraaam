package pl.umk.mat.jakuburb.Instagraaam;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.umk.mat.jakuburb.Instagraaam.controllers.AddPostController;
import pl.umk.mat.jakuburb.Instagraaam.controllers.BananController;
import pl.umk.mat.jakuburb.Instagraaam.controllers.RegisterController;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;

@SpringBootTest
class InstagraaamApplicationTests {

	@Autowired
	private RegisterController controller;

	@Autowired
	private BananController login;

	@Autowired
	private HttpSession session;

	@Test
	void checkLogin() {


		User user = new User("kuba", "abc" , "goryl");

		String answear = controller.getData(user, session);

		String answear2 = login.home2(user.getLogin(), user.getPassword(), session);

		Assertions.assertEquals(answear2, answear);
	}


	@Test
	void checkBadLogin() {


		User user = new User("kuba2", "abc" , "goryl");

		String answear = controller.getData(user, session);

		String answear2 = login.home2("gosc", user.getPassword(), session);

		Assertions.assertNotEquals(answear2, answear);
	}

}
