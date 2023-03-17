create database carpark

use carpark

create table employee(
[employeeid] bigint primary key identity(1,1),
[account] varchar(50),
[department] varchar(10),
[employeeaddress] varchar(50),
[employeebirthdate] date,
[employeeemail] varchar(50),
[employeename] varchar(50),
[employeephone] varchar(10),
[password] varchar(20),
[sex] varchar(1)
)

create table parkinglot(
[parkid] bigint primary key identity(1,1) ,
[parkarea] bigint ,
[parkname] varchar(50),
[parkplace] varchar(11),
[parkprice] bigint,
[parkstatus] varchar(50)
)
create table car(
[licenseplate] varchar(50) primary key,
[carcolor] varchar(11),
[cartype] varchar(50),
[company] varchar(50),
[parkid] bigint foreign key references parkinglot([parkid])
)
create table trip(
[tripid] bigint primary key identity(1,1),
[bookedticketnumber] int ,
[cartype] varchar(11),
[departuredate] date,
[departuretime] time,
[destination] varchar(50),
[driver] varchar(11),
[maximumonlineticketnumber] int
)
create table ticket(
[ticketid] bigint primary key identity(1,1),
[bookingtime] time,
[customername] varchar(11),
[licenseplate] varchar(50) foreign key references car([licenseplate]),
[tripid] bigint foreign key references trip([tripid])

)

create table bookingoffice(
[officeld] bigint identity(1,1) primary key,
[endcontractdeadline] date,
[officename] varchar(50),
[officephone] varchar(11),
[officeplace] varchar(50) ,
[officeprice] bigint,
[startcontractdeadline] date,
[tripid] bigint foreign key references trip([tripid])
)
insert into employee([account],[department] ,[employeeaddress] ,[employeebirthdate] ,[employeeemail] ,[employeename] ,[employeephone] ,[password] ,[sex])
values('admin','employee','ho chi minh','08/26/2000','admin@gmail.com','do gia hoang','0987665491','qteym2fzza==','m'),
      ('hoangdg','parking','ho chi minh','08/26/2000','hoangdg@gmail.com','do gia hoang','0987665481','qteym2fzza==','m'),
      ('hieudg','parking','ha noi','08/27/2000','hieudg@gmail.com','do gia hieu','0987665472','qteym2fzza==','f'),
	  ('handg','service','ha noi','08/27/2000','handg@gmail.com','do gia han','0987665462','qteym2fzza==','f'),
	  ('anhdh','service','ha noi','08/27/2000','anhdh@gmail.com','do hoang anh','0987665452','qteym2fzza==','f')
insert into parkinglot([parkarea], [parkname], [parkplace],[parkprice],[parkstatus])
values (20000, 'hn park','ha noi',20000,'ok'),
       (15000, 'hn park 2','ha noi',20000,'empty'),
	   (30000, 'hn park 3','hai phong',20000,'empty'),
	   (15000, 'hn park 4','ha noi 2',20000,'full')
insert into car (licenseplate, carcolor, cartype, company, parkid)
values('26m1-00005','blackpink','huyndai','fpt software',1),
      ('26m1-00006','whiteblue','ford','fpt univerisity',1),
	  ('26m1-00007','matcha','audi','viettel',2),
	  ('26m1-00008','deeppurple','ferrari','fpt software',3)

insert into trip([bookedticketnumber]  ,[cartype],[departuredate],[departuretime],[destination],[driver] ,[maximumonlineticketnumber] ) 
values (10,'audi', '12/12/2022','7:30:00', 'ca mau', 'mbappe',10),
       (11,'huyndai', '12/13/2022','7:31:00', 'ha giang', 'ronaldo',10),
       (12,'ford', '12/14/2022','7:32:00', 'phu quoc', 'messi',10),
       (13,'huyndai', '12/15/2022','7:33:00', 'ha giang', 'neymar',10)
insert into bookingoffice([endcontractdeadline],[officename] ,[officephone] ,[officeplace] ,[officeprice] ,[startcontractdeadline] , [tripid])
values('12/12/2002','phuong nam','0987648412','ha noi',2000,'11/12/2022',3),
      ('12/13/2002','phuong mai','0987648464','ha noi',3000,'11/12/2022',3),
      ('11/12/2002','ha nam','0987648499','ha noi',1500,'10/12/2022',3),
      ('10/02/2002','nam phuong','0987648478','ha noi',2500,'09/12/2022',4)
insert into ticket([bookingtime],[customername] ,[licenseplate] ,[tripid])
values('12:12:00','hoang','26m1-00005',3),
      ('12:12:01','viet','26m1-00006',2),
      ('12:12:01','dat','26m1-00007',1),
      ('12:12:00','thinh','26m1-00005',3)

      
