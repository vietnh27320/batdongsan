use estate32020module1part1;

INSERT INTO user(username,fullname,password,status) VALUES('nguyenvana','nguyen van a','123456',1);
INSERT INTO user(username,fullname,password,status) VALUES('nguyenvanb','nguyen van b','123456',1);
INSERT INTO user(username,fullname,password,status) VALUES('nguyenvanc','nguyen van c','123456',1);
INSERT INTO user(username,fullname,password,status) VALUES('nguyenvand','nguyen van d','123456',1);

INSERT INTO role(name,code) VALUES('Quản lý','manager');
INSERT INTO role(name,code) VALUES('Nhân viên','staff');

INSERT INTO user_role(userid,roleid) VALUES(1,1);
INSERT INTO user_role(userid,roleid) VALUES(2,2);
INSERT INTO user_role(userid,roleid) VALUES(3,2);
INSERT INTO user_role(userid,roleid) VALUES(4,2);

INSERT INTO building(name,numberofbasement,floorarea,district,ward,street,rentprice,
rentpricedescription,managername,managerphone,type) 
VALUES('Nam Giao Building Tower',2,500,'QUAN_1','Phường 2','59 phan xích long',
15,'15 triệu/m2','thoa','123456','TANG_TRET,NGUYEN_CAN');

INSERT INTO building(name,numberofbasement,floorarea,district,ward,street,rentprice,
rentpricedescription,managername,managerphone,type) 
VALUES('ACM Tower',2,650,'QUAN_2','Phường 4','96 cao thắng',
18,'18 triệu/m2','cương','123456','NGUYEN_CAN');

INSERT INTO building(name,numberofbasement,floorarea,district,ward,street,rentprice,
rentpricedescription,managername,managerphone,type) 
VALUES('Alpha 2 Building Tower',1,200,'QUAN_1','Phường 6','153 nguyễn đình chiểu',
20,'20 triệu/m2','huy','123456','NOI_THAT');

INSERT INTO building(name,numberofbasement,floorarea,district,ward,street,rentprice,
rentpricedescription,managername,managerphone,type) 
VALUES('IDD 1 Building',1,200,'QUAN_4','Phường 7','111 Lý Chính Thắng',
12,'12 triệu/m2','vy','123456','TANG_TRET,NGUYEN_CAN,NOI_THAT');

INSERT INTO rentarea(value,buildingid) VALUES(100,1);
INSERT INTO rentarea(value,buildingid) VALUES(200,1);
INSERT INTO rentarea(value,buildingid) VALUES(200,2);
INSERT INTO rentarea(value,buildingid) VALUES(300,2);
INSERT INTO rentarea(value,buildingid) VALUES(400,2);
INSERT INTO rentarea(value,buildingid) VALUES(300,3);
INSERT INTO rentarea(value,buildingid) VALUES(400,3);
INSERT INTO rentarea(value,buildingid) VALUES(500,3);
INSERT INTO rentarea(value,buildingid) VALUES(100,4);
INSERT INTO rentarea(value,buildingid) VALUES(400,4);
INSERT INTO rentarea(value,buildingid) VALUES(250,4);

INSERT INTO assignmentbuilding(staffid,buildingid) VALUES(2,1);
INSERT INTO assignmentbuilding(staffid,buildingid) VALUES(2,3);
INSERT INTO assignmentbuilding(staffid,buildingid) VALUES(3,1);
INSERT INTO assignmentbuilding(staffid,buildingid) VALUES(3,4);
