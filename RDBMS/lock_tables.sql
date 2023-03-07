
CREATE TABLE messages ( 
    id INT NOT NULL AUTO_INCREMENT, 
    message VARCHAR(100) NOT NULL, 
    PRIMARY KEY (id) 
);

INSERT INTO messages(message) VALUES('Hello');

SELECT CONNECTION_ID();
SELECT * FROM messages;

LOCK TABLE messages READ;

INSERT INTO messages(message) VALUES('Hi');
-------------------------------------------------------------------------

Check the READ lock from a different session.

Connect to the database and check the connection id:

SELECT CONNECTION_ID();
INSERT INTO messages(message) VALUES('Hello');
-------------------------------------------------------------------------

In main session

SHOW PROCESSLIST;

unlock tables;

SHOW PROCESSLIST;

-------------------------------------------------------------------------
LOCK TABLE messages WRITE;

INSERT INTO messages(message) VALUES('Hi');

lock table emp read, dept write;

-------------------------------------------------------------------------

CREATE TABLE t (a INT NOT NULL, b INT, c INT, INDEX (b)) ENGINE = InnoDB;
INSERT INTO t VALUES (1,2,3),(2,2,4);
COMMIT;
select * from t;

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

# Session A
START TRANSACTION;
UPDATE t SET b = 3 WHERE b = 2 AND c = 3;

# Session B
UPDATE t SET b = 4 WHERE b = 2 AND c = 4;