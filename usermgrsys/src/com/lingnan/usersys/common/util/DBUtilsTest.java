package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class DBUtilsTest {


	@Test
	public void testGetConnection() {
		Connection conn=DBUtils.getConnection();		
	}

}
