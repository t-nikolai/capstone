drop database if exists camping_community;
create database camping_community;
use camping_community;

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
insert into camper(username, `password`, `role`,first_name, last_name, camping_method, phone, email, address, city, state, zip)
	values
    ("user","password", "USER", "Ms.", "Camper", "C Method 1", "(111)111-1111", "cemail1@cemail1.com", "C Street 1", "C City 1", "S1", 11111),
    ("admin","secretpassword", "ADMIN", "Mr.", "Admin", "C Method 2", "(222)222-2222", "admin@campingcommunity.com", "C Street 2", "C City 2", "S2", 22222);

insert into campground(`name`, address, city, state, zip,
	phone, email, capacity, standard_rate, weekend_rate)
values("Afton Campground", "6959 Peller Ave S", "Hastings", "MN", 55033, "(651)201-6780", 
		"afton.statepark@state.mn.us", 13, 30.00, 35.00),
    ("Town and Country Campground","12630 Boone Ave", "Savage", "MN", 55378, 
		"(962)445-1756", "townandcountrycampground@outlook.com", 15, 28.00, 36.50),
    ("Lebanon Hills Regional Park Campground","12100 Johnny Cake Ridge Rd", "Saint Paul", "MN",
		55124,"(651)480-7773","parks@co.dakota.mn.us", 14, 30.00, 40.00);

insert into campsite(`name`, campground_id)
values ("Afton A-1",1),
	("Afton A-2",1),
    ("Afton A-3",1),
    ("Afton A-4",1),
    ("Afton A-5",1),
    ("Afton A-6",1),
    ("Afton A-7",1),
    ("Afton A-8",1),
    ("Afton B-1",1),
    ("Afton B-2",1),
    ("Afton B-3",1),
    ("Afton B-4",1),
    ("Afton B-5",1),
    -- end of afton
    ("TC-1",2),
    ("TC-2",2),
    ("TC-3",2),
    ("TC-4",2),
    ("TC-5",2),
    ("TC-6",2),
    ("TC-7",2),
    ("TC-8",2),
    ("TC-9",2),
    ("TC-10",2),
    ("TC-11",2),
    ("TC-12",2),
    ("TC-13",2),
    ("TC-14",2),
    ("TC-15",2),
    -- end of TC
    ("LHRP 1",3),
    ("LHRP 2",3),
    ("LHRP 3",3),
    ("LHRP 4",3),
    ("LHRP 5",3),
    ("LHRP 6",3),
    ("LHRP 7",3),
    ("LHRP 8",3),
    ("LHRP 9",3),
    ("LHRP 10",3),
    ("LHRP 11",3),
    ("LHRP 12",3),
    ("LHRP 13",3),
    ("LHRP 14",3);