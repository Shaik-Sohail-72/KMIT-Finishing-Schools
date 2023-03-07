
/*
SET autocommit = 0; // 0 - Off, 1 - On
start transaction;
delete from emp where deptno = 20;
select ename, deptno from emp;
*/

/*
SET autocommit = 1; 
start transaction;
delete from emp where deptno = 10;
rollback;
select ename, deptno from emp;
*/

/*
SET autocommit = 1; 
delete from emp where deptno = 10;
select ename, deptno from emp;
*/

/*
SET autocommit = 0; 
start transaction;
truncate emp;
commit;
select ename, deptno from emp;
*/

/*
SET autocommit = 0; 
start transaction;
delete from emp;
delete from dept;
delete from salgrade;
commit;
select ename, deptno from emp;
*/

// Where clause not allowed in truncate
truncate emp where deptno = 10;

create table emp1 as select * from emp;

create table emp2 as select * from emp where deptno = 30; 

create table emp3 as select * from emp where 10; 

create table emp4 as select empno, ename, job, deptno from emp where deptno = 20; 

create table emp5 as select * from emp where 1=1;
