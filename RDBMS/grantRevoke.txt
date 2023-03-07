create user 'subbu'@'localhost' identified by 'kmit';
grant select on test.emp to 'subbu'@'localhost';

select distinct user from mysql.user where user <> '' order by user;

// Login to mysql with new user name - subbu

1) To login set the mysql path to the environment path settings
D:\MySQL\MySQL Server 8.0\bin;

2) Open a new command prompt with administrator rights

3) Run the following command to login as subbu

mysql -u subbu -p

When prompted for password enter
kmit

Change database to test

use test;

Execute the following commands to check granted permissions and error for what is not granted

select ename from emp;

select * from dept;

update emp set ename='Raj' where ename='SMITH';
-----------------------------------------------------------
grant select on dept to 'subbu'@'localhost';

grant update on test.emp to 'subbu'@'localhost';
update emp set ename='Raj';
select * from dept;
----------------------------------------------------------
GRANT ALL PRIVILEGES ON test.emp TO 'subbu'@'localhost';

select ename from emp;
update emp set ename='ramesh' where ename='CLARK';
select ename from emp;
delete from emp where deptno = 20;
----------------------------------------------------------
revoke update on test.emp from 'subbu'@'localhost';
update emp set ename='Raj';

revoke select on test.emp from 'subbu'@'localhost';
select ename from emp;
----------------------------------------------------------
revoke ALL ON test.emp from 'subbu'@'localhost';

select ename from emp;
update emp set ename='ram' where ename='ALLEN';
drop table emp;
-----------------------------------------------------
SHOW GRANTS FOR 'subbu'@'localhost';

drop user 'subbu'@'localhost';
-----------------------------------------------------

grant execute on procedure test.empCount to 'subbu'@'localhost';
grant execute on function test.getSalGrade to 'subbu'@'localhost';

revoke execute on procedure test.empCount from 'subbu'@'localhost';
revoke execute on function test.getSalGrade from 'subbu'@'localhost';
--------------------------------------------------------

grant select on test.empdetails to 'subbu'@'localhost';
revoke select on test.empdetails from 'subbu'@'localhost';

--------------------------------------------------------
