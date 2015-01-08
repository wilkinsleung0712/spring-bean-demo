DROP table USER1.Student;
DROP table USER1.College;


create table USER1.Student (
    
   student_id int default NULL,
   student_name  VARCHAR(60) default NULL,
   college_id   int  default NULL,
   PRIMARY KEY (student_id)
);

create table USER1.College (
   
   college_id int default NULL,
   name  VARCHAR(60) default NULL,

   PRIMARY KEY (college_id)
);




INSERT INTO USER1.Student (student_id,student_name,college_id) values (1,'hipster',1);
INSERT INTO USER1.Student (student_id,student_name,college_id) values (2,'wilkins',1);
INSERT INTO USER1.Student (student_id,student_name,college_id) values (3,'vicky',2);
INSERT INTO USER1.Student (student_id,student_name,college_id) values (4,'tom',2);
INSERT INTO USER1.Student (student_id,student_name,college_id) values (5,'jack',3);

INSERT INTO USER1.College (college_id,name) values (1,'MIT');
INSERT INTO USER1.College (college_id,name) values (2,'RMIT');
INSERT INTO USER1.College (college_id,name) values (3,'Swinburne');
INSERT INTO USER1.College (college_id,name) values (4,'BOXHILL TAFE');