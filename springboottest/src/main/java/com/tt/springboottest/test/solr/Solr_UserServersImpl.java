package com.tt.springboottest.test.solr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("solr_UserService")
public class Solr_UserServersImpl implements Solr_UserServers {

	@Override
	public List<Solr_User> addUser() {
		ArrayList<Solr_User> solr_UserList = new ArrayList<Solr_User>();
		Solr_User solr_User1 = new Solr_User();
		solr_User1.setAge(13);
		solr_User1.setName("LILI1");

		Solr_User solr_User2 = new Solr_User();
		solr_User2.setAge(12);
		solr_User2.setName("LILI2");

		Solr_User solr_User3 = new Solr_User();
		solr_User3.setAge(11);
		solr_User3.setName("LILI3");
		solr_UserList.add(solr_User1);
		solr_UserList.add(solr_User2);
		solr_UserList.add(solr_User3);
		return solr_UserList;
	}

}
