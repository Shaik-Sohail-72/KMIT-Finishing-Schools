
prepare stmt1 from
'select * from emp where deptno = ?';

set @dno = 10;

EXECUTE stmt1 USING @dno;

set @dno = 20;

EXECUTE stmt1 USING @dno;

DEALLOCATE PREPARE stmt1;

