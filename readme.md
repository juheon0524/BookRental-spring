<<<<<<< HEAD
-- 자바 11 , tomcat9

-- pom.xml 
1. lombok 추가
2. HikariCP 추가
3. mybatis 추가
4. log4jdbc 추가
5. security 추가
6. mysql 추가

-- root-context.xml
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
		<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
		<property name="jdbcUrl" value="jdbc:log4jdbc:mysql://localhost:3306/db_scott"></property>
		<property name="username" value="scott"></property>
		<property name="password" value="tiger"></property>
</bean>

-- web.xml 
=======
-- 자바 11 , tomcat9

-- pom.xml 
1. lombok 추가
2. HikariCP 추가
3. mybatis 추가
4. log4jdbc 추가
5. security 추가
6. mysql 추가

-- root-context.xml
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
		<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
		<property name="jdbcUrl" value="jdbc:log4jdbc:mysql://localhost:3306/db_scott"></property>
		<property name="username" value="scott"></property>
		<property name="password" value="tiger"></property>
</bean>

-- web.xml 
>>>>>>> 3db49983efad1a7683607830dfb5eee77b884ef5
한글설정