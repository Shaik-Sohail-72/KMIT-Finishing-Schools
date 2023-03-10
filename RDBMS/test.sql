DELIMITER $$
 
CREATE function getDeptSal(dno int) returns varchar(30)
BEGIN
    DECLARE sum1 varchar(20);
    DECLARE avg1 varchar(20);
    DECLARE min1 varchar(20);
    DECLARE max1 varchar(20);
 
	select sum(sal) INTO sa1l from emp where deptno = dno;
    select avg(sal) INTO avg1 from emp where deptno = dno;
    select min(sal) INTO min1 from emp where deptno = dno;
    select max(sal) INTO max1 from emp where deptno = dno;
	return concat(sal1, avg1, min1, max1); 
END$$

DELIMITER ;

select getDeptSal(20);