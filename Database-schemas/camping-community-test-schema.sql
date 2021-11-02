drop database if exists camping_community_test;
create database camping_community_test;
use camping_community_test;

-- create tables and relationships
create table campground (
    campground_id int not null primary key auto_increment,
    name varchar(70) not null,
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
    site_name varchar(10) not null,
    
    campground_id int not null,
    constraint fk_campsite_campground_id
		foreign key (campground_id)
        references campground(campground_id)
);

create table camper (
	camper_id int not null primary key auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    camping_method varchar(30) not null, -- enum ?
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
insert into campground(campground_name, campground_address, campground_city, campground_state, campground_zip,
	campground_phone, campground_email, campground_capacity, standard_rate, weekend_rate)
values("Test CG Name 1", "CG Street 1", "CG City 1", "S1", 11111, "(111)111-1111", 
	"cgemail1@cgemail1.com", 11, 10.00, 11.00);
    
insert into campsite(site_name, campground_id)
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
    ("Site 11", 1);
    
insert into camper(first_name, last_name, camping_method, camper_phone, camper_email, camper_address, camper_city, camper_state, camper_zip)
	values
    ("C First Name 1", "C Last Name 1", "C Method 1", "(111)111-1111", "cemail1@cemail1.com", "C Street 1", "C City 1", "S1", 11111);
    
insert into reservation(start_date, end_date, site_id, camper_id)
	values
    ("1111-11-11", "1111-11-12", 1, 1);
    
delimiter //
create procedure set_known_good_state()
begin

delete from campground;
alter table alias auto_increment = 1;
delete from campsite;
alter table campsite auto_increment = 1;
delete from camper;
alter table camper auto_increment = 1;
delete from reservation;
alter table reservation auto_increment = 1;

insert into campground(campground_name, campground_address, campground_city, campground_state, campground_zip,
	campground_phone, campground_email, campground_capacity, standard_rate, weekend_rate)
values("Test CG Name 1", "CG Street 1", "CG City 1", "S1", 11111, "(111)111-1111", 
	"cgemail1@cgemail1.com", 11, 10.00, 11.00);
    
insert into campsite(site_name, campground_id)
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
    ("Site 11", 1);
    
insert into camper(first_name, last_name, camping_method, camper_phone, camper_email, camper_address, camper_city, camper_state, camper_zip)
	values
    ("C First Name 1", "C Last Name 1", "C Method 1", "(111)111-1111", "cemail1@cemail1.com", "C Street 1", "C City 1", "S1", 11111);
    
insert into reservation(start_date, end_date, site_id, camper_id)
	values
    ("1111-11-11", "1111-11-12", 1, 1);

end //
-- 4. Change the statement terminator back to the original.
delimiter ;