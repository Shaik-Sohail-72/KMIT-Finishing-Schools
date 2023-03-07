select TABLE_NAME from information_schema.TABLES where TABLE_SCHEMA ='mysql';

desc information_schema.routines;

SELECT 
    routine_name
FROM
    information_schema.routines
WHERE
    routine_type = 'PROCEDURE'
        AND routine_schema = 'test';

--------------------------------------------------------

select * from mysql.user;

select distinct user from mysql.user where user <> '' order by user;

drop user USERNAME;

show create procedure setCounter;

--------------------------------------------------------

show create function getSalGrade;

--------------------------------------------------------


select trigger_name FROM information_schema.TRIGGERS WHERE
TRIGGER_SCHEMA=database();

SELECT * FROM information_schema.TRIGGERS WHERE
TRIGGER_SCHEMA=database();

show create trigger ondelete_emp;