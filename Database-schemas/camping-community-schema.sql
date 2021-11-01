drop database if exists camping_community;
create database camping_community;
use camping_community;

-- create tables and relationships
create table campground (
    campground_id int not null primary key auto_increment,
    campground_name varchar(70) not null,
    --
    campground_address varchar(50) not null,
    campground_city varchar(50) not null,
    campground_state varchar(2) not null,
    campground_zip int(5) not null,
    --
    campground_phone varchar(20) not null,
    campground_email varchar(50) not null,
    campground_capacity int not null,
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
    camper_phone varchar(20) null,
    camper_email varchar(50) not null,
    -- 
    camper_address varchar(50) not null,
    camper_city varchar(50) not null,
    camper_state varchar(2) not null,
    camper_zip int(5) not null
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
