package br.com.bluereports.util;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.json.JSONException;
import org.json.JSONObject;

public class StringJsonUserType implements UserType {

	private static final int[] SQL_TYPES = { Types.JAVA_OBJECT };

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return deepCopy(cached);
	}

	public Object deepCopy(Object value) throws HibernateException {
		if (value == null)
			return value;
		try {
			return new JSONObject(((JSONObject) value).toString());
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return ((JSONObject) value).toString();
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == null)
			return (y != null);
		return (x.equals(y));
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public boolean isMutable() {
		return true;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		if (!rs.wasNull()) {
			if (rs.getString(names[0]) == null) {
				return null;
			}
			return rs.getString(names[0]);
		}
		return null;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.OTHER);
			return;
		}
		st.setObject(index, value, Types.OTHER);
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	public Class returnedClass() {
		return String.class;
	}

	public int[] sqlTypes() {
		return new int[] { Types.JAVA_OBJECT };
	}

}
