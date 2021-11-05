drop database if exists camping_community_test;
create database camping_community_test;
use camping_community_test;

-- create tables and relationships
create table campground (
    campground_id int not null primary key auto_increment,
    `name` varchar(70) not null,
    --
    address varchar(50) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip int(5) not null,
    --
    phone varchar(20) not null,
    email varchar(50) not null,
    capacity int not null,
    --
    standard_rate decimal(6,2) not null,
    weekend_rate decimal(6,2) not null
);

create table campsite (
	site_id int not null primary key auto_increment,
    `name` varchar(10) not null,
    
    campground_id int not null,
    constraint fk_campsite_campground_id
		foreign key (campground_id)
        references campground(campground_id)
);

create table camper (
	camper_id int not null primary key auto_increment,
    username varchar(30) not null,
    `password` varchar(50) not null,
    `role` varchar(12) not null,
    
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    camping_method varchar(30) not null, 
    phone varchar(20) null,
    email varchar(50) not null,
    -- 
    address varchar(50) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip int(5) not null
);

create table reservation (
	reservation_id int not null primary key auto_increment,
    start_date date not null,
    end_date date not null,
    total decimal(6,2) not null,
    
    site_id int not null,
    constraint fk_reservation_site_id
		foreign key (site_id)
        references campsite(site_id),
        
	camper_id int not null,
    constraint fk_reservation_camper_id
		foreign key (camper_id)
        references camper(camper_id)
);

-- data
    
delimiter //
create procedure set_known_good_state()
begin

delete from reservation;
alter table reservation auto_increment = 1;
delete from campsite;
alter table campsite auto_increment = 1;
delete from camper;
alter table camper auto_increment = 1;
delete from campground;
alter table campground auto_increment = 1;

insert into campground(`name`, address, city, state, zip,
	phone, email, capacity, standard_rate, weekend_rate)
values("Test CG Name 1", "CG Street 1", "CG City 1", "S1", 11111, "(111)111-1111", 
	"cgemail1@cgemail1.com", 11, 10.00, 11.00),
    ("Test CG Name 2", "CG Street 2", "CG City 2", "S2", 22222, "(222)222-2222", 
	"cgemail2@cgemail2.com", 22, 20.00, 22.00),
    ("Test CG Name 3", "CG Street 3", "CG City 3", "S3", 33333, "(333)333-3333", 
	"cgemail3@cgemail3.com", 33, 30.00, 33.00),
    ("Test CG Name 4", "CG Street 4", "CG City 4", "S4", 44444, "(444)444-4444", 
	"cgemail4@cgemail4.com", 44, 14.00, 44.00);
	
    
insert into campsite(`name`, campground_id)
	values
    ("Site 1", 1),
    ("Site 2", 1),
    ("Site 3", 1),
    ("Site 4", 1),
    ("Site 5", 1),
    ("Site 6", 1),
    ("Site 7", 1),
    ("Site 8", 1),
    ("Site 9", 1),
    ("Site 10", 1),
    ("Site 11", 1), 
    -- cg 2
    ("Site 1", 2),
    ("Site 2", 2),
    ("Site 3", 2),
    ("Site 4", 2),
    ("Site 5", 2),
    ("Site 6", 2),
    ("Site 7", 2),
    ("Site 8", 2),
    ("Site 9", 2),
    ("Site 10", 2),
    ("Site 11", 2),
    -- cg 3
    ("Site 1", 3),
    ("Site 2", 3),
    ("Site 3", 3),
    ("Site 4", 3),
    ("Site 5", 3),
    ("Site 6", 3),
    ("Site 7", 3),
    ("Site 8", 3),
    ("Site 9", 3),
    ("Site 10", 3),
    ("Site 11", 3),
    -- cg 4
    ("Site 1", 4),
    ("Site 2", 4),
    ("Site 3", 4),
    ("Site 4", 4),
    ("Site 5", 4),
    ("Site 6", 4),
    ("Site 7", 4),
    ("Site 8", 4),
    ("Site 9", 4),
    ("Site 10", 4),
    ("Site 11", 4);
    
insert into camper(username, `password`, `role`, first_name, last_name, camping_method, phone, email, address, city, state, zip)
	values
    ("user1", "password", "USER", "C First Name 1", "C Last Name 1", "C Method 1", "(111)111-1111", "cemail1@cemail1.com", "C Street 1", "C City 1", "S1", 11111),
    ("user2", "password", "USER", "C First Name 2", "C Last Name 2", "C Method 2", "(222)222-2222", "cemail2@cemail2.com", "C Street 2", "C City 2", "S2", 22222),
    ("user3", "password", "USER", "C First Name 3", "C Last Name 3", "C Method 3", "(333)333-3333", "cemail3@cemail3.com", "C Street 3", "C City 3", "S3", 33333),
    ("admin", "secretpassword", "ADMIN", "C First Name 4", "C Last Name 4", "C Method 4", "(444)444-4444", "cemail4@cemail4.com", "C Street 4", "C City 4", "S4", 44444);
    
insert into reservation(start_date, end_date, total, site_id, camper_id)
	values
    ("2021-01-01", "2021-01-02", 11.00, 1, 1),
    ("2022-02-02", "2022-02-03", 20.00, 2, 2),
    ("2023-03-03", "2023-03-04", 33.00, 3, 3),
    ("2024-04-04", "2024-04-05", 14.00, 4, 4);

end //
-- 4. Change the statement terminator back to the original.
delimiter ;

set sql_safe_updates = 0;
call set_known_good_state();
set sql_safe_updates = 1;