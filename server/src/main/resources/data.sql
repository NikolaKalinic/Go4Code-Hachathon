use db_facebook;

insert into user (email, password, username) values ('peter23@gmail.com', 'peter123','PetarJames');
insert into user (email, password, username) values ('susana12@gmail.com', 'susana458','SusanaCurry');
insert into user (email, password, username) values ('maria78@gmail.com', 'maria123','MariaTowns');
insert into user (email, password, username) values ('john11@gmail.com', 'john123','JohnWall');
insert into user (email, password, username) values ('rudy10@gmail.com', 'rudy123','RudyGobert');
insert into user (email, password, username) values ('michae23@gmail.com', 'michael123','MichaelJordan');

insert into post (attachment, content, date, rating, viewers,user_id) values ('','You are best basketball ever.','2022-02-15 18:36:37',3,'4','6');
insert into post (attachment, content, date, rating, viewers,user_id) values ('','That is insane.','2022-02-15 18:40:36',4,'5','6');
insert into post (attachment, content, date, rating, viewers,user_id) values ('','Are you sure?','2022-02-19 15:13:26',5,'3','1');
insert into post (attachment, content, date, rating, viewers,user_id) values ('','Hello my friend!','2022-02-23 15:45:18',3,'4','2');
insert into post (attachment, content, date, rating, viewers,user_id) values ('','Big day for us!!!','2022-02-24 16:51:33',4,'4','3');
insert into post (attachment, content, date, rating, viewers,user_id) values ('','What are you doing?','2022-03-25 21:33:14',4,'3','4');
insert into post (attachment, content, date, rating, viewers,user_id) values ('','Hey, how much costs?','2022-03-25 17:51:33',5,'4','5');

insert into comment(attachment, content, date, post_id, user_id) values ('','Comment1','2022-02-19 15:17:26',3,2);
insert into comment(attachment, content, date, post_id, user_id) values ('','Comment2','2022-02-19 15:18:33',3,3);
insert into comment(attachment, content, date, post_id, user_id) values ('','Comment3','2022-02-15 18:41:44',1,4);
insert into comment(attachment, content, date, post_id, user_id) values ('','Comment4','2022-02-19 15:18:33',2,1);
insert into comment(attachment, content, date, post_id, user_id) values ('','Comment5','2022-02-19 15::33',4,3);
