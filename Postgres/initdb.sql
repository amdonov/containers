
CREATE TABLE custauth (
    custid integer NOT NULL,
    fname text NOT NULL,
    lname text NOT NULL,
    city text NOT NULL,
    state text,
    country text NOT NULL,
    email text,
    cost money NOT NULL,
    errorflag integer NOT NULL
);

INSERT INTO custauth VALUES (1, 'Fred', 'David', 'Springfield', 'Virginia', 'USA', 'ilikecs@gmail.com', '$23.23', 0);
INSERT INTO custauth VALUES (2, 'Lisa', 'Smith', 'Little Rock', 'Arkanas', 'USA', 'code2win@yahoo.com', '$344.32', 0);
INSERT INTO custauth VALUES (3, 'Tom', 'Richardson', 'Virginia Beach', 'Virginia', 'USA', 'lasersharks@gmail.com', '$342.34', 0);
INSERT INTO custauth VALUES (4, 'Sean', 'Cruz', 'Durham', 'North Carolina', 'USA', 'SeanCruz@gmail.com', '$34.23', 0);
INSERT INTO custauth VALUES (5, 'Nick', 'Beacker', 'San Francisco', 'California', 'USA', 'B_Nick@gmail.com', '$2,324.33', 0);
INSERT INTO custauth VALUES (6, 'Haoyi', 'Chen', 'Beijing', 'missing', 'China', 'forigenuser@beibei.com', '$9,999.99', 0);




ALTER TABLE ONLY custauth
    ADD CONSTRAINT custauth_pkey PRIMARY KEY (custid);
